// package com.zjt.mapper;
//
// import com.zjt.model.Person;
// import com.zjt.sout.entity.SysPerson;
// import com.zjt.sout.mapper.SysPersonMapper;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;
//
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
//
// import static org.junit.Assert.*;
//
// /**
//  * @author zhou.jingtao
//  * @date created in 12:31 2018/12/2
//  * @Description:
//  */
//
// @SpringBootTest
// @RunWith(SpringRunner.class)
// public class PersonMapperTest {
//
//     @Autowired
//     private SysPersonMapper sysPersonMapper;
//
//     @Test
//     public void mapperListTest(){
//         List<SysPerson> personList = sysPersonMapper.selectList(null);
//         personList.forEach(System.out :: println);
//     }
//
//     @Test
//     public void saveTest(){
//         SysPerson sysPerson = new SysPerson();
//         sysPerson.setName("asd");
//         sysPerson.setAge(12);
//         sysPerson.setScore(13);
//
//         SysPerson sysPerson1 = new SysPerson();
//         sysPerson.setName("a22sd");
//         sysPerson.setAge(12);
//         sysPerson.setScore(113);
//         sysPersonMapper.insert(sysPerson1);
//
//     }
//
//     @Test
//     public void deleteByMap(){
//         Map<String,Object> map = new HashMap();
//         SysPerson sysPerson = new SysPerson();
//         map.put("age",12);
//         sysPersonMapper.deleteByMap(map);
//     }
//
// }