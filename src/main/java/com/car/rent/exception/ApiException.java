package com.car.rent.exception;

import com.car.rent.enums.response.IErrorCode;
import lombok.Getter;

/**
 * 自定义Api异常
 * @author nayix
 * @date 2020/7/4 15:21
 */
@Getter
public class ApiException extends RuntimeException {
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }
}
