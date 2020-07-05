package com.car.rent.constant.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nayix
 * @date 2020/6/30 16:38
 */
@Getter
@AllArgsConstructor
public enum ResultCode implements IErrorCode {
    // 成功
    SUCCESS(200, "操作成功"),

    // 身份过期
    UNAUTHORIZED(401, "身份过期"),

    // 拒绝访问
    FORBIDDEN(403, "权限不足"),

    // 未找到或请求字段为空
    NOTFOUND(404, "未找到"),

    // 参数不符合要求
    VALIDATE_FAILED(406, "参数校验失败"),

    // 操作失败
    FAILED(500, "操作失败"),

    // 车辆不可用
    UNAVAILABLE(4001, "车辆不可用"),

    // 存在未完成账单
    UNFINISHED(4002, "有账单正在进行中"),

    // 余额不足
    POOR(4003, "余额不足"),
    ;

    private final long code;
    private final String message;
}
