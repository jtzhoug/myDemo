package com.zjt.enums;

import lombok.Getter;

/**
 * @author zhou.jingtao
 * @date created in 23:23 2018/10/4
 * @Description:
 */

@Getter
public enum ResultEnum {

    SUCCESS(0,"成功"),

    SYSTEM_ERROR(40000,"系统异常"),

    STUDENT_NOT_EXIT(40001,"该学生不存在"),

    PERMISSION_NOT_ALLOW(40002,"权限不足"),

    YOU_NOT_LOGIN(40003,"您尚未登录")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
