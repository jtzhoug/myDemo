package com.zjt.sys.service.impl;

import com.zjt.sys.entity.Post;
import com.zjt.sys.mapper.PostMapper;
import com.zjt.sys.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-12-26
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
