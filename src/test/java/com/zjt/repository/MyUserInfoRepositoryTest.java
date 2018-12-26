package com.zjt.repository;

import com.zjt.model.MyUserInfo;
import com.zjt.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhou.jingtao
 * @date created in 10:25 2018/10/8
 * @Description:
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class MyUserInfoRepositoryTest {

    @Autowired
    private UserInfoService userInfoService;
    @Test
    public void findByName() throws Exception {
        MyUserInfo userInfo = userInfoService.findByUserName("admin");
        System.out.println(userInfo.getName());
    }

}