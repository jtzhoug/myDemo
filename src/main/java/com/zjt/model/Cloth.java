package com.zjt.model;

import lombok.Data;

/**
 * @author zhou.jingtao
 * @date created in 10:15 2018/11/19
 * @Description:
 */
@Data
public class Cloth {
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

    private String auditorRole;

    public Cloth(Integer itemId, Integer serialNum, String auditorName, Integer meetingId, Integer score, String checkedLabel, String remark, String auditorRole) {
        this.itemId = itemId;
        this.serialNum = serialNum;
        this.auditorName = auditorName;
        this.meetingId = meetingId;
        this.score = score;
        this.checkedLabel = checkedLabel;
        this.remark = remark;
        this.auditorRole = auditorRole;
    }

    public Cloth() {
    }
}
