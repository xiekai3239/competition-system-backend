package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成绩发布对象 bus_score
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
public class BusScore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成绩ID */
    private Long scoreId;

    /** 竞赛ID */
    @Excel(name = "竞赛ID")
    private Long compId;

    /** 报名ID（关联队伍） */
    @Excel(name = "报名ID", readConverterExp = "关=联队伍")
    private Long regId;

    /** 具体分数（支持两位小数） */
    @Excel(name = "具体分数", readConverterExp = "支=持两位小数")
    private BigDecimal scoreValue;

    /** 获奖等第（关联字典：特等奖、一等奖等） */
    @Excel(name = "获奖等第", readConverterExp = "关=联字典：特等奖、一等奖等")
    private String awardLevel;

    /** 排名 */
    @Excel(name = "排名")
    private Long ranking;

    /** 是否发布（0未发布 1已发布） */
    @Excel(name = "是否发布", readConverterExp = "0=未发布,1=已发布")
    private String isPublish;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 竞赛名称 */
    private String compName;

    /** 队伍名称 */
    private String teamName;

    public void setScoreId(Long scoreId) 
    {
        this.scoreId = scoreId;
    }

    public Long getScoreId() 
    {
        return scoreId;
    }

    public void setCompId(Long compId) 
    {
        this.compId = compId;
    }

    public Long getCompId() 
    {
        return compId;
    }

    public void setRegId(Long regId) 
    {
        this.regId = regId;
    }

    public Long getRegId() 
    {
        return regId;
    }

    public void setScoreValue(BigDecimal scoreValue) 
    {
        this.scoreValue = scoreValue;
    }

    public BigDecimal getScoreValue() 
    {
        return scoreValue;
    }

    public void setAwardLevel(String awardLevel) 
    {
        this.awardLevel = awardLevel;
    }

    public String getAwardLevel() 
    {
        return awardLevel;
    }

    public void setRanking(Long ranking) 
    {
        this.ranking = ranking;
    }

    public Long getRanking() 
    {
        return ranking;
    }

    public void setIsPublish(String isPublish) 
    {
        this.isPublish = isPublish;
    }

    public String getIsPublish() 
    {
        return isPublish;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("scoreId", getScoreId())
            .append("compId", getCompId())
            .append("regId", getRegId())
            .append("scoreValue", getScoreValue())
            .append("awardLevel", getAwardLevel())
            .append("ranking", getRanking())
            .append("isPublish", getIsPublish())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("compName", getCompName())
            .append("teamName", getTeamName())
            .toString();
    }
}
