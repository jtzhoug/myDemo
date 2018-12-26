package com.zjt.repository;

import com.zjt.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author zhou.jingtao
 * @date created in 18:14 2018/10/4
 * @Description:
 */
// @CacheConfig
public interface StudentRepository extends JpaRepository<Student,Integer> {

    // @Cacheable
    List<Student> findStudentByUserId(Integer userId);

    List<Student> findStudentByName(String name);





}
