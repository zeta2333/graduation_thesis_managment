package usts.cs2020.utils.result;

import lombok.Getter;

/**
 * @author Pycro
 * @version 1.0
 * 2023-06-22 2:45 PM
 */
@Getter
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    FAIL(201, "失败"),

    DATA_ERROR(204, "数据异常"),
    SERVICE_ERROR(205, "服务异常"),

    LOGIN_AUTH(208, "未登陆"),
    PERMISSION(209, "没有权限");

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
