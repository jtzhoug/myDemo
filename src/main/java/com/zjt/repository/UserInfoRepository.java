package com.zjt.repository;

import com.zjt.model.MyUserInfo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhou.jingtao
 * @date created in 10:13 2018/10/8
 * @Description:
 */
// @CacheConfig
public interface UserInfoRepository extends JpaRepository<MyUserInfo,Integer>{

    // @Cacheable
    public MyUserInfo findByUsername(String userName);
}
