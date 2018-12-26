package com.zjt.service.Impl;

import com.zjt.model.Student;
import com.zjt.repository.StudentRepository;
import com.zjt.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhou.jingtao
 * @date created in 21:32 2018/10/4
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public Student addStudent(Student student) {
        Student student1 = studentRepository.findById(student.getId()).get();
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Integer id) {

        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudent(Integer id) {
         studentRepository.deleteById(id);
    }

    @Override
    public Student update(Integer id, Student student) {

        Student currentStudent = studentRepository.findById(id).get();
        BeanUtils.copyProperties(student,currentStudent,"id");
        return studentRepository.save(currentStudent);
    }

    @Override
    public void save(List<Student> studentList) {
        for (Student student : studentList){
            studentRepository.save(student);
        }
    }


}
