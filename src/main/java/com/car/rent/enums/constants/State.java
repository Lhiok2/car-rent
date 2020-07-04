package com.car.rent.enums.constants;

import com.car.rent.entity.Car;
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
    NORMAL("Normal"),

    // used
    USED("Used"),

    // malfunction
    MALFUNCTION("Malfunction")
    ;

    private final String state;

    public static List<String> toStringList() {
        return Arrays.stream(State.values()).map(State::getState).collect(Collectors.toList());
    }

    public static boolean isNormal(Car car) {
        return NORMAL.state.equals(car.getState());
    }
}
