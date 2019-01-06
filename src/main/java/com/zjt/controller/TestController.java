package com.zjt.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zjt.model.Result;
import com.zjt.model.Test;
import com.zjt.repository.TestRepository;
import com.zjt.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * @Auther: zhou.jingtao
 * @Date: 2018-12-29 09:24
 * @Description:
 */
@RequestMapping("/testJson")
@RestController
public class TestController {

    @Autowired
    private TestRepository testRepository;

    @RequestMapping("/save")
    public Result save(@RequestBody JSONObject jsonObject){
        String userName = jsonObject.getString("userName");
        JSONArray jsonArray = jsonObject.getJSONArray("mediaIds");
        Test test = new Test();
        test.setUserName(userName);
        test.setJsonValue(jsonArray.toJavaList(String.class));
        test.setCreateTime(new Date());


        Test t1 = testRepository.save(test);
        return ResultUtil.success(t1);
    }

    @RequestMapping("/getOne")
    public Result getOne(HttpServletRequest request){
        Integer id = Integer.valueOf(request.getParameter("id"));

        Test test = testRepository.findById(id).get();
        return ResultUtil.success(JSON.toJSONString(test.getJsonValue()));
    }

    @RequestMapping("/saveRequest")
    public Result save(HttpServletRequest request) {
        JSONObject jsonParam = null;
        try {
            // 获取输入流
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));

            // 写入数据到Stringbuilder
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = streamReader.readLine()) != null) {
                sb.append(line);
            }
            jsonParam = JSONObject.parseObject(sb.toString());
            // 直接将json信息打印出来
            System.out.println(jsonParam.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultUtil.success(jsonParam);
    }
}
