package com.zjt.javaTest;

import com.zjt.model.Student;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhou.jingtao
 * @date created in 17:42 2018/11/15
 * @Description:
 */
public class StreamTest {
    public static void main(String[] args) {
        Student student1 = new Student("ab", "12", "12", 1, 12, 100);
        Student student2 =new Student("abc", "12", "12", 1, 14, 100);
        Student student3 = new Student("abcd", "12", "12", 1, 122, 100);
        Student student4 =new Student("abcde", "12", "12", 1, 6, 120);
        List<Student> alist = new ArrayList();
        alist.add(student1);
        alist.add(student2);
        alist.add(student3);
        alist.add(student4);

        List<Integer> result = new ArrayList<>();
        for (Student x : alist){
            result.add(x.getAge());
        }
        System.out.println(result);
        System.out.println(result.size());
        List<Integer> resultStream = alist.stream().map(x -> x.getAge()).collect(Collectors.toList());
        Double avg = alist.parallelStream().collect(Collectors.averagingDouble(Student :: getSalary));

        Integer sum = alist.parallelStream().map(x -> x.getAge()).reduce(0,Integer::sum);
        Map<Integer,Long> s = alist.parallelStream().collect(Collectors.groupingBy(Student :: getAge,Collectors.counting()));
        // System.out.println(s.size() + "ss" + s.get(12));
        // System.out.println(avg);
        // System.out.println(sum);
        // System.out.println(resultStream);
        // System.out.println(resultStream.size());
       Map map = (Map) alist.stream().collect(Collectors.groupingBy(Student :: getAge,Collectors.counting()));
        // System.out.println(map.size());
        // System.out.println(map.get(12));
        // System.out.println(map.get(14));
        // System.out.println(map.get(6));

        List<Student> studentList = Arrays.asList(

                new Student("ab", "12", "12", 1, 12, 100),
                new Student("abc", "12", "12", 1, 14, 100),
                new Student("abcd", "12", "12", 1, 12, 100),
                new Student("abcde", "12", "12", 1, 6, 100)
        );

        List<Student> students = studentList.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        List<Student> list = studentList.stream()
                .filter(x -> x.getAge() > 11)
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .collect(Collectors.toList());
        System.out.println(students);

        System.out.println(111);
        System.out.println(list);
    }


    //删选age大于13的人
    List<Student> studentList = Arrays.asList(

            new Student("ab", "12", "12", 1, 12, 100),
            new Student("abc", "12", "12", 1, 14, 100),
            new Student("abcd", "12", "12", 1, 12, 100),
            new Student("abcde", "12", "12", 1, 6, 100)
    );

    public List<Student> filterStudent(List<Student> studentList) {
        List<Student> students = new ArrayList<>();

        for (Student student : studentList) {
            if (student.getAge() > 13) {
                students.add(student);
            }
        }
        return students;
    }


}
