package com.car.rent.vo;

import com.car.rent.constant.response.IErrorCode;
import com.car.rent.constant.response.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author nayix
 * @date 2020/6/30 16:32
 */
@Data
@AllArgsConstructor
@ApiModel("通用响应数据构造类")
public class CommonResult<T> {
    @ApiModelProperty("请求响应状态码")
    private long code;
    @ApiModelProperty("请求结果描述信息")
    private String message;
    @ApiModelProperty("请求结果数据")
    private T data;

    /**
     * 成功返回结果
     */
    public static <T> CommonResult<T> success() {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功返回数据
     * @param data 获取的数据
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode) {
        return new CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed(IErrorCode errorCode, String message) {
        return new CommonResult<>(errorCode.getCode(), message, null);
    }

    /**
     * 参数校验失败
     */
    public static <T> CommonResult<T> validatedFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 权限不足
     */
    public static <T> CommonResult<T> forbiddenFailed() {
        return failed(ResultCode.FORBIDDEN);
    }
}
