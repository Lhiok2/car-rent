package com.car.rent.enums.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nayix
 * @date 2020/6/30 16:38
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    // success
    SUCCESS(200, "操作成功"),

    // unauthorized
    UNAUTHORIZED(401, "暂未登录或token已经过期"),

    // forbidden
    FORBIDDEN(403, "没有相关权限"),

    // validate failed
    VALIDATE_FAILED(404, "参数检验失败"),

    // failed
    FAILED(500, "操作失败")
    ;

    private final long code;
    private final String message;
}
