package com.zjt.service;

import com.zjt.model.MyUserInfo;

/**
 * @author zhou.jingtao
 * @date created in 10:14 2018/10/8
 * @Description:
 */
public interface UserInfoService {
    public MyUserInfo findByUserName(String userName);

}
