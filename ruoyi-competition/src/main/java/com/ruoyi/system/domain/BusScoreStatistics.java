package com.ruoyi.system.domain;

import java.math.BigDecimal;

/**
 * 成绩统计对象 bus_score_statistics
 * 
 * @author ruoyi
 * @date 2026-04-19
 */
public class BusScoreStatistics {
    /** 竞赛ID */
    private Long compId;

    /** 竞赛名称 */
    private String compName;

    /** 平均分 */
    private BigDecimal avgScore;

    /** 最高分 */
    private BigDecimal maxScore;

    public Long getCompId() {
        return compId;
    }

    public void setCompId(Long compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public BigDecimal getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(BigDecimal avgScore) {
        this.avgScore = avgScore;
    }

    public BigDecimal getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(BigDecimal maxScore) {
        this.maxScore = maxScore;
    }
}