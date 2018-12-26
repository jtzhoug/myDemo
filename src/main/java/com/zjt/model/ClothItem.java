package com.zjt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhou.jingtao
 * @date created in 16:42 2018/11/18
 * @Description:
 */
@Entity
@Table(name = "clothItem")
@Data


public class ClothItem implements Serializable{

    @Id
    @GeneratedValue
    private Integer itemId;

    //款号Id
    private Integer serialNum;

    //评审人员姓名
    // @ManyToOne
    // @JoinColumn(name = "auditor_name")
    private String auditorName;

    //场次Id
    private Integer meetingId;
    //
    // //款号Id
    // private Integer serialNum;

    //评分
    private Integer score;

    //标语
    private String checkedLabel;

    //详细描述
    private String remark;




    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")    // @Column(name = "create_time")
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")    private Date updateTime;

    @Transient
    private String auditorRole;
    // @OneToOne(mappedBy = "auditor")
    // private Auditor auditor;
    // @ManyToOne
    // @JoinColumn(name = "auditorName",referencedColumnName = "auditorName")
    // private Auditor auditor;
    // @ManyToOne(targetEntity = Auditor.class)
    // @JoinColumn(name = "clothItemAuditorName",referencedColumnName = "auditorName")
    // private Auditor auditor;
}

