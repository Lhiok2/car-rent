package com.car.rent.exception;

import com.car.rent.constant.response.IErrorCode;
import com.car.rent.constant.response.ResultCode;

/**
 * 断言处理类，用于抛出各种API异常
 * @author nayix
 * @date 2020/7/4 15:36
 */
public class Asserts {
    public static void fail() {
        throw new ApiException(ResultCode.FAILED);
    }

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

    public static void notFound() {
        throw new ApiException(ResultCode.NOTFOUND);
    }
}
