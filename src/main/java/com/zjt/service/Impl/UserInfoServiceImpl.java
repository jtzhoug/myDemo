package com.zjt.service.Impl;

import com.zjt.model.MyUserInfo;
import com.zjt.repository.UserInfoRepository;
import com.zjt.service.UserInfoService;
import com.zjt.sys.entity.User;
import com.zjt.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhou.jingtao
 * @date created in 10:14 2018/10/8
 * @Description:
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public MyUserInfo findByUserName(String userName) {
        return userInfoRepository.findByUsername(userName);
//        return userMapper.selectByUserName(userName);

    }
}
