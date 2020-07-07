package com.car.rent.utils;

import com.car.rent.domain.Bill;
import com.car.rent.constant.BillState;

import java.util.Date;

/**
 * @author nayix
 * @date 2020/7/1 23:15
 */
public class BillUtils {
    private static final long HOUR_TO_MS = 1000 * 60 * 60;

    /**
     * 账单结算 小时计费
     * @param bill
     * @return
     */
    public static void settleBill(Bill bill) {
        bill.setBillState(BillState.UNPAID.getState());
        bill.setEndTime(new Date());
        long ms = bill.getEndTime().getTime() - bill.getStartTime().getTime();
        long hours = (ms / HOUR_TO_MS) + (ms % HOUR_TO_MS == 0? 0: 1);
        long cost = bill.getCar().getPrice() * hours;
        bill.setCost(cost);
    }
}
