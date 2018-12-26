package com.zjt.controller;

import com.zjt.enums.ResultEnum;
import com.zjt.model.Result;
import com.zjt.utils.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author zhou.jingtao
 * @date created in 10:18 2018/10/8
 * @Description:
 */
@Controller
public class LoginController {

    @RequestMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping("/unLogin")
    @ResponseBody
    public Result unLogin(HttpServletRequest request, HttpServletResponse response){
        return ResultUtil.error(ResultEnum.YOU_NOT_LOGIN);

    }

    @RequestMapping("/login")
    @ResponseBody
    public Result login(HttpServletRequest request, Map<String, Object> map) throws Exception {


        System.out.println("HomeController.login");

        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        Object exception = request.getAttribute("shiroLoginFailure");
//        String exception = (String) request.getAttribute("shiroLoginFailure");
        String username = request.getParameter("userName");
        String password = request.getParameter("password");


        Subject subject = SecurityUtils.getSubject();
        //认证提交前准备token
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        String msg = "";
        try {
            subject.login(token);
            msg = "登录成功";
        } catch (IncorrectCredentialsException e){
            msg = "密码不正确";
        } catch (AuthenticationException e){
            msg = "账户不存在";
        }

            // if (exception != null) {

        //     if (UnknownAccountException.class.getName().equals(exception)) {
        //         System.out.println("账户不存在");
        //         msg = "账户不存在或密码不正确";
        //     } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
        //         System.out.println("密码不正确");
        //         msg = "账户不存在或密码不正确";
        //     } else {
        //         System.out.println("其他异常");
        //         msg = "其他异常";
        //     }
        // } else {
        //     msg = "登录成功";
        // }

        map.put("msg", msg);
        map.put("test", "111");
        // 此方法不处理登录成功,由shiro进行处理.
        // return "login";
        return ResultUtil.error(1,msg);
        // return new ModelAndView("login", "map", map);
    }

    //用户查询
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userInfo() {
        return new ModelAndView("userInfo");
    }
//    用户添加

    @RequestMapping(value = "/userAdd", method = RequestMethod.GET)
    // @RequiresPermissions("userInfo:add")
    @RequiresRoles("admin")
    public ModelAndView userAdd() {
        return new ModelAndView("userInfoAdd");
    }


    //    用户删除
    @RequestMapping(value = "/userDel", method = RequestMethod.GET)
    @RequiresPermissions("userInfo:del")
    public ModelAndView userDel() {
        return new ModelAndView("userInfoDel");
    }
}

