package com.zjt.sys.mapper;

import com.zjt.sys.entity.User;
import org.apache.shiro.crypto.hash.Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: zhou.jingtao
 * @Date: 2018-12-26 22:11
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void test(){
//        User user = userMapper.selectByUserName("admin");
        List<User> user = userMapper.selectList(null);
         user.forEach(System.out :: println);
    }

    @Test
    public void save(){
        User user = new User();
        user.setLoginName("zz");
        user.setDeptId(111);
        int result = userMapper.insert(user);
        System.out.println(result);
    }

    @Test
    public void deleteBatch(){
        List<Integer> list = new ArrayList<>();
        list.add(100);
        list.add(101);
        int result = userMapper.deleteBatchIds(list);
        System.out.println(result);

    }

    @Test
    public void deleteByMap(){
        Map map = new HashMap<>();
        map.put("login_name","zz");
        map.put("user_name","qq");
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }
}