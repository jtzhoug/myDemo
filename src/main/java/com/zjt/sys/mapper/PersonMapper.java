package com.zjt.sys.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zjt.sys.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2018-12-04
 */
//@DS("slave_1")
@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    List<Map<String,Object>> selectPartSysPerson();
}
