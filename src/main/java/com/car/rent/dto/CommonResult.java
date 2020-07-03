package com.car.rent.dto;

import com.car.rent.enums.response.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nayix
 * @date 2020/6/30 16:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("通用响应数据构造类")
public class CommonResult<T> {
    @ApiModelProperty("请求响应状态码")
    private long code;
    @ApiModelProperty("请求结果描述信息")
    private String message;
    @ApiModelProperty("请求结果数据")
    private T data;

    private static <T> CommonResult<T> getResult(ResultCode resultCode, T data) {
        return new CommonResult<>(resultCode.getCode(), resultCode.getMessage(), data);
    }

    /**
     * 成功返回数据
     */
    public static <T> CommonResult<T> success(T data) {
        return data == null? notFound(): getResult(ResultCode.SUCCESS, data);
    }

    /**
     * data为空返回失败信息 非空返回成功信息
     */
    public static <T> CommonResult<T> success(T data, ResultCode failedCode) {
        return data == null? failed(failedCode): getResult(ResultCode.SUCCESS, data);
    }

    /**
     * 成功返回结果
     */
    public static <T> CommonResult<T> success() {
        return getResult(ResultCode.SUCCESS, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResult<T> failed(ResultCode resultCode) {
        return new CommonResult<>(resultCode.getCode(), resultCode.getMessage(), null);
    }

    /**
     * 身份过期
     */
    public static <T> CommonResult<T> unauthorized() {
        return failed(ResultCode.UNAUTHORIZED);
    }

    /**
     * 参数不符合要求
     */
    public static <T> CommonResult<T> notAcceptable() {
        return failed(ResultCode.NOT_ACCEPTABLE);
    }

    /**
     * 权限不足
     */
    public static <T> CommonResult<T> forbidden() {
        return failed(ResultCode.FORBIDDEN);
    }

    /**
     * 未找到或请求字段为空
     */
    public static <T> CommonResult<T> notFound() {
        return failed(ResultCode.NOTFOUND);
    }

    public static <T> CommonResult<T> internalError() {
        return failed(ResultCode.INTERNAL_ERROR);
    }

    /**
     * 根据code返回结果 >0: success else: failed
     */
    public static <T> CommonResult<T> getResultByCode(int code) {
        return code > 0? success(): failed(ResultCode.INTERNAL_ERROR);
    }

    /**
     * 根据code返回结果 >0: success else: 自定义错误
     */
    public static <T> CommonResult<T> getResultByCode(int code, ResultCode resultCode) {
        return code > 0? success(): failed(resultCode);
    }
}
