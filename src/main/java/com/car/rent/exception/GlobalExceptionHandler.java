package com.car.rent.exception;

import com.car.rent.vo.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author nayix
 * @date 2020/7/4 15:33
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult<?> handle(ApiException e) {
        return e.getErrorCode() == null? CommonResult.failed(e.getMessage()): CommonResult.failed(e.getErrorCode());
    }
}
