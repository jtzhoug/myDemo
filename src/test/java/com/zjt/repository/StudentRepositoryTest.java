package com.zjt.repository;

import com.zjt.model.Student;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhou.jingtao
 * @date created in 13:49 2018/10/11
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;
    public void test(){
        Student student = studentRepository.getOne(1);
        System.out.println(student);
    }

}