package com.car.rent.utils;

import com.car.rent.constant.response.ResultCode;
import com.car.rent.exception.Asserts;
import org.dozer.DozerBeanMapper;
import org.springframework.data.domain.Page;

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
        if (sourceObj == null) {
            Asserts.fail(ResultCode.NOTFOUND);
        }
        return dozerBeanMapper.map(sourceObj, destinationClass);
    }

    public static <T> List<T> mapList(Page<?> sourceList, Class<T> destinationClass) {
        return sourceList.stream().map((o) -> map(o, destinationClass)).collect(Collectors.toList());
    }
}
