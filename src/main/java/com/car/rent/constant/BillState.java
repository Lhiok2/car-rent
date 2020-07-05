package com.car.rent.constant;

import com.car.rent.domain.Bill;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nayix
 * @date 2020/6/30 15:46
 */
@Getter
@AllArgsConstructor
public enum BillState {
    // trading
    TRADING("Trading"),

    // unpaid
    UNPAID("Unpaid"),

    // paid
    PAID("Paid")
    ;

    private final String state;

    public static List<String> toStringList() {
        return Arrays.stream(BillState.values()).map(BillState::getState).collect(Collectors.toList());
    }

    public static boolean isUnpaid(Bill bill) {
        return UNPAID.state.equals(bill.getBillState());
    }
}
