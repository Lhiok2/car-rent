package com.car.rent.service.impl;

import com.car.rent.dao.BillDAO;
import com.car.rent.dao.CarDAO;
import com.car.rent.dao.UserDAO;
import com.car.rent.dto.BillDTO;
import com.car.rent.entity.Bill;
import com.car.rent.entity.Car;
import com.car.rent.entity.User;
import com.car.rent.enums.constants.BillState;
import com.car.rent.enums.constants.State;
import com.car.rent.enums.response.ResultCode;
import com.car.rent.exception.ApiException;
import com.car.rent.exception.Asserts;
import com.car.rent.service.BillService;
import com.car.rent.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.Date;

import static com.car.rent.enums.constants.BillState.isUnpaid;
import static com.car.rent.enums.constants.State.isNormal;
import static com.car.rent.utils.BillUtils.settleBill;

/**
 * @author nayix
 * @date 2020/6/30 16:24
 */
@Slf4j
@Service
public class BillServiceImpl implements BillService {
    @Resource
    private BillDAO billDAO;
    @Resource
    private CarDAO carDAO;
    @Resource
    private UserDAO userDAO;

    @Override
    @Transactional
    public BillDTO addBill(long uid, long cid) {
        try {
            // 有未完成的交易
            Bill bill = billDAO.getRecentBill(uid);
            if (bill != null) {
                Asserts.fail(ResultCode.UNFINISHED);
            }
            // 车辆不可用
            Car car = carDAO.findCarsByCid(cid);
            if (!isNormal(car)) {
                Asserts.fail(ResultCode.UNAVAILABLE);
            }
            // 更新车辆状态为使用中
            int code = carDAO.updateState(cid, State.USED.getState());
            if (code != 1) {
                Asserts.fail();
            }
            // 生成交易账单
            bill = billDAO.save(Bill.builder()
                    .user(User.builder().uid(uid).build())
                    .car(Car.builder().cid(cid).build())
                    .billState(BillState.TRADING.getState())
                    .startTime(new Date()).build());
            return DozerUtils.map(bill, BillDTO.class);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("BillService-addBill[ uid:" + uid + " cid:" + cid + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    @Transactional
    public BillDTO updateState(long uid, long cid) {
        try {
            // 查询订单正确性
            Bill bill = billDAO.getRecentBill(uid);
            if (bill == null || bill.getCar().getCid() != cid) {
                Asserts.notFound();
            }
            // 更新车辆状态
            int code = carDAO.updateState(cid, State.NORMAL.getState());
            if (code != 1) {
                Asserts.fail();
            }
            settleBill(bill);
            bill = billDAO.save(bill);
            return DozerUtils.map(bill, BillDTO.class);
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("BillService-updateState[ uid:" + uid + " cid:" + cid + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    @Transactional
    public void completePayment(long billId, long uid) {
        try {
            // 查询账单正确性
            Bill bill = billDAO.getRecentBill(uid);
            if (bill == null || bill.getBillId() != billId || !isUnpaid(bill)) {
                Asserts.notFound();
            }
            // 查询余额是否够支付
            User user = userDAO.findUserByUid(uid);
            if (user.getBalance() < bill.getCost()) {
                Asserts.fail(ResultCode.POOR);
            }
            int balance = user.getBalance() - bill.getCost();
            int code1 = userDAO.updateBalance(uid, balance);
            int code2 = billDAO.updateStateToPaid(billId);
            if (code1 != 1 || code2 != 1) {
                Asserts.fail();
            }
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.info("BillService-completePayment[ uid:" + uid + " billId:" + billId + " message:" + e.getMessage() + "]");
            throw e;
        }
    }

    @Override
    public BillDTO getUnfinishedBill(long uid) {
        Bill bill = billDAO.getRecentBill(uid);
        return DozerUtils.map(bill, BillDTO.class);
    }
}
