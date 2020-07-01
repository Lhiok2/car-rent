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

    public static boolean belongs(String stateStr) {
        for (State s : State.values()) {
            if (stateStr.equals(s.getState())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNormal(String stateStr) {
        return stateStr.equals(NORMAL.getState());
    }
}
