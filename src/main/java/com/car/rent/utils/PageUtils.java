package com.car.rent.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 * @author nayix
 * @date 2020/7/6 0:40
 */
public class PageUtils {
    public static Pageable getPageable(Integer pageIndex, Integer pageSize) {
        return PageRequest.of(pageIndex-1, pageSize);
    }
}
