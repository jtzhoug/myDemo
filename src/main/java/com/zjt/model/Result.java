package com.zjt.model;

import lombok.Data;

/**
 * @author zhou.jingtao
 * @date created in 23:03 2018/10/4
 * @Description:
 */

@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;


}
