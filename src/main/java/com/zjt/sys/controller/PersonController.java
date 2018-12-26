package com.zjt.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.zjt.model.Result;
import com.zjt.sys.entity.Person;
import com.zjt.sys.mapper.PersonMapper;
import com.zjt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2018-12-04
 */
@RestController
@RequestMapping("/sys/person")
public class PersonController {

    @Autowired
    private PersonMapper personMapper;


    @RequestMapping("/test")
    public com.zjt.model.Result test(){
        Map<String,Object> map = new HashMap<>();
        map.put("age",12);
        List<Person> sysPersonList = personMapper.selectByMap(map);
        // List<SysPerson> personList = sysPersonMapper.
        List<Map<String,Object>> maps = personMapper.selectPartSysPerson();
        return ResultUtil.success(maps);
    }

    @RequestMapping("/pageTest")
    public Result testPage(@RequestBody JSONObject jsonObject){
        Integer page =  jsonObject.getInteger("page");

        return  ResultUtil.success("");

    }
}
