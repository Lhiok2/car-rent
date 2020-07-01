package com.car.rent.dto;

import com.car.rent.enums.response.ResultCode;
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
public class CommonResult<T> {
    private long code;
    private String message;
    private T data;

    private static <T> CommonResult<T> getResult(ResultCode resultCode, T data) {
        return new CommonResult<>(resultCode.getCode(), resultCode.getMessage(), data);
    }

    /**
     * 成功返回数据
     */
    public static <T> CommonResult<T> success(T data) {
        return getResult(ResultCode.SUCCESS, data);
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
