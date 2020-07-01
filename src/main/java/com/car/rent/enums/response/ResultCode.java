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
    // 成功
    SUCCESS(200, "Success"),

    // 身份过期
    UNAUTHORIZED(401, "Unauthorized"),

    // 拒绝访问
    FORBIDDEN(403, "Forbidden"),

    // 未找到
    NOTFOUND(404, "Not Found"),

    // 参数不符合要求
    NOT_ACCEPTABLE(406, "Not Acceptable"),

    // 服务器发生意料之外的错误
    INTERNAL_ERROR(500, "Internal Server Error")
    ;

    private final long code;
    private final String message;
}
