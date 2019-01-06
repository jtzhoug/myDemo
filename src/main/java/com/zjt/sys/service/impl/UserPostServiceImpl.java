package com.zjt.sys.service.impl;

import com.zjt.sys.entity.UserPost;
import com.zjt.sys.mapper.UserPostMapper;
import com.zjt.sys.service.IUserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-12-26
 */
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements IUserPostService {

}
