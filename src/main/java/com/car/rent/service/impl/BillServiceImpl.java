package com.car.rent.service.impl;

import com.car.rent.dao.BillDAO;
import com.car.rent.dao.CarDAO;
import com.car.rent.dto.BillDTO;
import com.car.rent.entity.Bill;
import com.car.rent.entity.Car;
import com.car.rent.entity.User;
import com.car.rent.enums.constants.BillState;
import com.car.rent.enums.constants.State;
import com.car.rent.service.BillService;
import com.car.rent.utils.DozerUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

import static com.car.rent.enums.constants.State.isNormal;
import static com.car.rent.utils.BillUtils.settleBill;

/**
 * @author nayix
 * @date 2020/6/30 16:24
 */
@Service
public class BillServiceImpl implements BillService {
    @Resource
    private BillDAO billDAO;
    @Resource
    private CarDAO carDAO;

    @Override
    public BillDTO addBill(long uid, long cid) {
        int code = carDAO.updateState(cid, State.USED.getState());
        if (code <= 0) {
            return null;
        }
        Bill bill = billDAO.save(Bill.builder()
                .user(User.builder().uid(uid).build())
                .car(Car.builder().cid(cid).build())
                .billState(BillState.TRADING.getState())
                .startTime(new Date()).build());
        return DozerUtils.map(bill, BillDTO.class);
    }

    @Override
    public BillDTO updateState(long uid, long cid) {
        Bill bill = billDAO.getRecentBill(uid);
        if (bill == null || bill.getCar().getCid() != cid) {
            return null;
        }
        int code = carDAO.updateState(cid, State.NORMAL.getState());
        if (code <= 0) {
            return null;
        }
        settleBill(bill);
        bill = billDAO.save(bill);
        return DozerUtils.map(bill, BillDTO.class);
    }

    @Override
    public int completePayment(long billId) {
        return billDAO.updateStateToPaid(billId);
    }

    @Override
    public BillDTO getUnfinishedBill(long uid) {
        Bill bill = billDAO.getRecentBill(uid);
        return DozerUtils.map(bill, BillDTO.class);
    }
}
