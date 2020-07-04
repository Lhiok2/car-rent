package com.car.rent.enums.response;

/**
 * 封装API错误码
 * @author nayix
 * @date 2020/7/4 15:26
 */
public interface IErrorCode {
    /**
     * 返回错误码
     * @return 错误码
     */
    long getCode();

    /**
     * 返回错误信息
     * @return 错误信息
     */
    String getMessage();
}
