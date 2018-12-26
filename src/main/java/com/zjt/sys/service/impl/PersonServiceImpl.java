package com.zjt.sys.service.impl;

import com.zjt.sys.entity.Person;
import com.zjt.sys.mapper.PersonMapper;
import com.zjt.sys.service.IPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-12-04
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
