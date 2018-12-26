package com.zjt.service;

import com.zjt.model.MyUserInfo;
import com.zjt.repository.UserInfoRepository;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhou.jingtao
 * @date created in 10:14 2018/11/8
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyUserInfoServiceTest {
    @Autowired
    private UserInfoService userInfoService;


    @Autowired
    private UserInfoRepository userInfoRepository;
    @Test
    public void findByUserName() throws Exception {
        String username = "admin";

        // MyUserInfo userInfo = userInfoRepository.findById(1).get();
        MyUserInfo userInfo = userInfoRepository.findByUsername(username);
        System.out.println(userInfo.getPassword());
    }

    @Test
    public void test(){
        int hashInterations = 10;
        Object salt = "YWRtaW4=";
        Object credentials = "123456";
        String hashAlgorithmName = "MD5";//加密方式
        Object simpleHash = new SimpleHash(hashAlgorithmName,credentials,salt,hashInterations);

        System.out.println(simpleHash);
    }


}