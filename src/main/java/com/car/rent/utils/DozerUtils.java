package com.car.rent.utils;

import org.dozer.DozerBeanMapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author nayix
 * @date 2020/6/30 15:08
 */
public class DozerUtils {
    private static final DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    public static <T> T map(Object sourceObj, Class<T> destinationClass) {
        return dozerBeanMapper.map(sourceObj, destinationClass);
    }

    public static <T> List<T> mapList(Collection<?> sourceList, Class<T> destinationClass) {
        return sourceList.stream().map((o) -> map(o, destinationClass)).collect(Collectors.toList());
    }
}
