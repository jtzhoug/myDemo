package com.zjt.model;

import lombok.Data;

/**
 * @author zhou.jingtao
 * @date created in 16:54 2018/11/23
 * @Description: 某场会议下所有评论的星级统计封装类
 */
@Data
public class ScoreCountVO {

    private Integer score;

    private Long scoresCounts;

    public ScoreCountVO(Integer score, Long scoresCounts) {
        this.score = score;
        this.scoresCounts = scoresCounts;
    }

    public ScoreCountVO() {
    }
}
