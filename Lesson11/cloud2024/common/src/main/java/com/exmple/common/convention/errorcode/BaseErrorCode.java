package com.exmple.common.convention.errorcode;

/**
 * @Author 70ash
 * @Date 2024/1/24 23:18
 * @Description:
 */
public enum BaseErrorCode implements IErrorCode{
    CLIENT_ERROR("A00001", "用户端错误"),
    USER_NOT_EXIST("A00100", "用户不存在"),
    USER_NAME_EXIST("A00101", "用户名已存在"),
    USER_INSERT_FAIL("A00102", "用户新增失败"),
    USER_LOGIN_FAIL("A00103", "账号或密码错误"),
    USER_ALREADY_LOGIN("A00104", "用户已登录"),
    SERVICE_ERROR("B00001", "系统错误"),
    REMOTE_ERROR("C00001", "远程调用错误");
    private String code;

    private String message;

    BaseErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
