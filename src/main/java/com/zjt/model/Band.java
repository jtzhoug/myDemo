package com.zjt.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author zhou.jingtao
 * @date created in 22:45 2018/11/21
 * @Description:
 */
@Entity
@Data
public class Band {

    @Id
    @GeneratedValue
    private Integer id;

    private String series;

    private Integer meetingId;

    private String bandRange;


}
