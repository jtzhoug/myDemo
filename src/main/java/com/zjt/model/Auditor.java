package com.zjt.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhou.jingtao
 * @date created in 16:43 2018/11/18
 * @Description:
 */
@Entity
@Data
@Table(name = "auditor")
public class Auditor implements Serializable{

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer auditorId;

    //评委名
    private String auditorName;

    private Integer meetingId;

    //用户角色 0设计师 1买手 2加盟商
    private String auditorRole;

    //创建人
    private String userName;

    private String mobile;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")    // @Column(name = "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;

    // @OneToOne
    // @JoinColumn(name = "auditorName",referencedColumnName = "auditorName" ,insertable=false ,updatable=false)
    // private ClothItem clothItem;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "auditorName")
    // private List<ClothItem> clothItems;





}