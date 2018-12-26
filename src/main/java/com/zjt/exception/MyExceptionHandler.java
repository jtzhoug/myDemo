package com.zjt.exception;

import com.zjt.enums.ResultEnum;
import com.zjt.model.Result;
import com.zjt.utils.ResultUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhou.jingtao
 * @date created in 16:54 2018/10/5
 * @Description:
 */

@ControllerAdvice
public class MyExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handel(Exception e){
        if (e instanceof MyExpection){
            MyExpection myExpection = (MyExpection) e;
            return ResultUtil.error(myExpection.getCode(),myExpection.getMsg());
        }
        if (e instanceof UnauthorizedException){
            return ResultUtil.error(ResultEnum.PERMISSION_NOT_ALLOW);
        }else {
            logger.error("[异常] {}",e);
            return ResultUtil.error(ResultEnum.SYSTEM_ERROR);
        }
    }
}
