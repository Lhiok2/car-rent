package com.car.rent.service;

import com.car.rent.dto.BillDTO;

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
    BillDTO addBill(long uid, long cid);

    /**
     * 结束骑行
     * @param uid
     * @param cid
     * @return
     */
    BillDTO updateState(long uid, long cid);

    /**
     * 完成支付
     * @param billId
     * @return
     */
    int completePayment(long billId);

    /**
     * 获取最近一次订单
     * @param uid
     * @return
     */
    BillDTO getUnfinishedBill(long uid);
}
