package com.car.rent.constant;

import com.car.rent.domain.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author nayix
 * @date 2020/6/28 19:49
 */
@Getter
@AllArgsConstructor
public enum State {
    // normal
    NORMAL("正常"),

    // used
    USED("使用中"),

    // malfunction
    MALFUNCTION("待维修")
    ;

    private final String state;

    public static List<String> toStringList() {
        return Arrays.stream(State.values()).map(State::getState).collect(Collectors.toList());
    }

    public static boolean isNormal(Car car) {
        return NORMAL.state.equals(car.getState());
    }
}
