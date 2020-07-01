package com.car.rent.enums.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

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
}
