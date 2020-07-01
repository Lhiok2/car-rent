package com.car.rent.utils;

import com.car.rent.entity.Bill;
import com.car.rent.enums.constants.BillState;

import java.util.Date;

/**
 * @author nayix
 * @date 2020/7/1 23:15
 */
public class BillUtils {
    /**
     * TODO 账单结算
     * @param bill
     * @return
     */
    public static void settleBill(Bill bill) {
        bill.setBillState(BillState.UNPAID.getState());
        bill.setEndTime(new Date());
        long minutes = bill.getEndTime().getTime() - bill.getStartTime().getTime();
        int cost = 0;
        bill.setCost(cost);
    }
}
