package com.zjt.sys.service.impl;

import com.zjt.sys.entity.UserRole;
import com.zjt.sys.mapper.UserRoleMapper;
import com.zjt.sys.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-12-26
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
