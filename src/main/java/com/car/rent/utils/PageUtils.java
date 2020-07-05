package com.car.rent.utils;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author nayix
 * @date 2020/7/6 0:40
 */
public class PageUtils {
    public static Pageable getPageable(Integer pageIndex, Integer pageSize) {
        if (pageIndex == null || pageIndex < 1) {
            pageIndex = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 5;
        }
        final int size = pageSize;
        final int pageNum = (pageIndex - 1) * pageSize;
        return new Pageable() {
            @Override
            public int getPageNumber() {
                return pageNum;
            }

            @Override
            public int getPageSize() {
                return size;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        };
    }
}
