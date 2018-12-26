package com.zjt.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: zhou.jingtao
 * @Date: 2018-12-24 15:15
 * @Description:
 */
@Entity
@Data
public class Test {

    @Id
    @GeneratedValue
    private Integer id;

    private Date createTime;

    private String userName;

    public Test(Date createTime, String userName) {
        this.createTime = createTime;
        this.userName = userName;
    }
}
