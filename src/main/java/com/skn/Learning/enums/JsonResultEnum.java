package com.skn.Learning.enums;

/**
 * Exception的错误代码 与 错误信息 的 枚举
 */
public enum JsonResultEnum {

    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),

    ADMIN_VALIDATE_ERROR(100, "验证码输入错误！"),
    ADMIN_USER_NULL(101, "管理员用户名不存在！"),
    ADMIN_PASS_ERROR(102, "密码输入错误！"),
    ADMIN_USER_LOCKING(103, "该管理员已被系统锁定！"),
    ;

    private Integer code;

    private String msg;

    /**
     * 构造方法为private目的就是为了不让你用new来创建该类型的对象，而枚举类型的个数必须是确定的（根据枚举体的作用定义)所以它必须是private
     * @param code
     * @param msg
     */
    private JsonResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg; 
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
