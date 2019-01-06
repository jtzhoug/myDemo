package com.zjt.sys.controller;


import com.zjt.model.Result;
import com.zjt.sys.entity.User;
import com.zjt.sys.mapper.UserMapper;
import com.zjt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2018-12-26
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/test")
    public Result test(@RequestParam("userName") String userName){
        User user = userMapper.selectByUserName(userName);
        return ResultUtil.success(user);
    }

    /**
     *
     *  保存
     * @param
     * @return
     */

    @RequestMapping("/save")
    public Result save(){
        User user = new User();
        user.setLoginName("zz");
        user.setDeptId(111);
        user.setUserName("ssss");
        int result = userMapper.insert(user);
        System.out.println(result);
        return ResultUtil.success(result);
    }
}
