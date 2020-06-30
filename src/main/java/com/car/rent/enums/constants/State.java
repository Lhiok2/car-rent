package com.car.rent.enums.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nayix
 * @date 2020/6/28 19:49
 */
@Getter
@AllArgsConstructor
public enum State {
    // normal
    NORMAL("Normal"),

    // used
    USED("Used"),

    // malfunction
    MALFUNCTION("Malfunction")
    ;

    private final String state;
}
