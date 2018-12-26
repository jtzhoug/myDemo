package com.zjt.exception;

import com.zjt.enums.ResultEnum;
import lombok.Data;

/**
 * @author zhou.jingtao
 * @date created in 16:49 2018/10/5
 * @Description:
 */
@Data
public class MyExpection extends RuntimeException{

    private Integer code;

    private String msg;

    public MyExpection(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }
}
