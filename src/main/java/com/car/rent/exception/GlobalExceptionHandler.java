package com.car.rent.exception;

import com.car.rent.dto.CommonResult;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
