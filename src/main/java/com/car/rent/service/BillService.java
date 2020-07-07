package com.car.rent.service;

import com.car.rent.vo.BillVO;
import com.car.rent.exception.ApiException;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author nayix
 * @date 2020/6/30 16:24
 */
public interface BillService {
    /**
     * 新增账单
     * @param uid
     * @param cid
     * @return
     */
    BillVO addBill(long uid, long cid) throws ApiException;

    /**
     * 结束骑行
     * @param uid
     * @param cid
     * @return
     */
    BillVO updateState(long uid, long cid);

    /**
     * 完成支付
     * @param billId
     * @param uid
     * @return
     */
    void completePayment(long billId, long uid);

    /**
     * 获取最近一次订单
     * @param uid
     * @return
     */
    BillVO getUnfinishedBill(long uid);

    /**
     * 获取账单列表
     * @param uid
     * @param pageable
     * @return
     */
    List<BillVO> getBillList(long uid, Pageable pageable);
}
