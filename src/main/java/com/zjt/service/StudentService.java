package com.zjt.service;

import com.zjt.model.Student;

import java.util.List;

/**
 * @author zhou.jingtao
 * @date created in 21:31 2018/10/4
 * @Description:
 */
public interface StudentService {

    public Student addStudent(Student student);

    public List<Student> getStudentList();

    public Student getStudent(Integer id);

    public void deleteStudent(Integer id);

    public Student update(Integer id,Student student);

    public void save(List<Student> studentList);

}
