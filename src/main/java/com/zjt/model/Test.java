package com.zjt.model;

import com.alibaba.fastjson.JSON;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @Auther: zhou.jingtao
 * @Date: 2018-12-24 15:15
 * @Description:
 */
@Entity
@Data
@TypeDef(name = "json", typeClass = JsonStringType.class)

public class Test {

    @Id
    @GeneratedValue
    private Integer id;

    private Date createTime;

    private String userName;


    @Type( type = "json" )
    @Column( columnDefinition = "json" )
    private List<String> jsonValue;


    public Test() {
    }

    public Test(Date createTime, String userName, List<String> jsonValue) {
        this.createTime = createTime;
        this.userName = userName;
        this.jsonValue = jsonValue;
    }
}
