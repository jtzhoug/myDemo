package com.zjt.sys.mapper;

import com.zjt.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2018-12-26
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByUserName(String userName);

}
