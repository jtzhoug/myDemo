package com.zjt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author zhou.jingtao
 * @date created in 21:52 2018/9/27
 * @Description:
 */
@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String mobile;

    private String sex;

    private Integer userId;

    private Integer age;

    private Integer salary;



    public Student(String name, String mobile, String sex, Integer userId, Integer age, Integer salary) {
        this.name = name;
        this.mobile = mobile;
        this.sex = sex;
        this.userId = userId;
        this.age = age;
        this.salary = salary;
    }

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name = "create_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")    // @Column(name = "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")    private Date updateTime;

    public Student() {

    }
}
