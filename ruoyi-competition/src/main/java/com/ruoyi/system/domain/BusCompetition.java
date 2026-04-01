package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 竞赛信息对象 bus_competition
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
public class BusCompetition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 竞赛ID */
    private Long compId;

    /** 竞赛名称 */
    @Excel(name = "竞赛名称")
    private String compName;

    /** 竞赛级别（关联字典：国家级、省级、校级） */
    @Excel(name = "竞赛级别", readConverterExp = "关=联字典：国家级、省级、校级")
    private String compLevel;

    /** 竞赛类别（关联字典：创新创业、学科竞赛等） */
    @Excel(name = "竞赛类别", readConverterExp = "关=联字典：创新创业、学科竞赛等")
    private String compType;

    /** 主办单位 */
    @Excel(name = "主办单位")
    private String organizer;

    /** 报名开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报名开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signStartTime;

    /** 报名截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报名截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signEndTime;

    /** 竞赛开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "竞赛开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date compStartTime;

    /** 竞赛结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "竞赛结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date compEndTime;

    /** 竞赛详情/通知正文 */
    @Excel(name = "竞赛详情/通知正文")
    private String content;

    /** 附件地址（多文件按逗号分隔） */
    @Excel(name = "附件地址", readConverterExp = "多=文件按逗号分隔")
    private String attachment;

    /** 发布状态（0发布 1草稿 2下架） */
    @Excel(name = "发布状态", readConverterExp = "0=发布,1=草稿,2=下架")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setCompId(Long compId) 
    {
        this.compId = compId;
    }

    public Long getCompId() 
    {
        return compId;
    }

    public void setCompName(String compName) 
    {
        this.compName = compName;
    }

    public String getCompName() 
    {
        return compName;
    }

    public void setCompLevel(String compLevel) 
    {
        this.compLevel = compLevel;
    }

    public String getCompLevel() 
    {
        return compLevel;
    }

    public void setCompType(String compType) 
    {
        this.compType = compType;
    }

    public String getCompType() 
    {
        return compType;
    }

    public void setOrganizer(String organizer) 
    {
        this.organizer = organizer;
    }

    public String getOrganizer() 
    {
        return organizer;
    }

    public void setSignStartTime(Date signStartTime) 
    {
        this.signStartTime = signStartTime;
    }

    public Date getSignStartTime() 
    {
        return signStartTime;
    }

    public void setSignEndTime(Date signEndTime) 
    {
        this.signEndTime = signEndTime;
    }

    public Date getSignEndTime() 
    {
        return signEndTime;
    }

    public void setCompStartTime(Date compStartTime) 
    {
        this.compStartTime = compStartTime;
    }

    public Date getCompStartTime() 
    {
        return compStartTime;
    }

    public void setCompEndTime(Date compEndTime) 
    {
        this.compEndTime = compEndTime;
    }

    public Date getCompEndTime() 
    {
        return compEndTime;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setAttachment(String attachment) 
    {
        this.attachment = attachment;
    }

    public String getAttachment() 
    {
        return attachment;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("compId", getCompId())
            .append("compName", getCompName())
            .append("compLevel", getCompLevel())
            .append("compType", getCompType())
            .append("organizer", getOrganizer())
            .append("signStartTime", getSignStartTime())
            .append("signEndTime", getSignEndTime())
            .append("compStartTime", getCompStartTime())
            .append("compEndTime", getCompEndTime())
            .append("content", getContent())
            .append("attachment", getAttachment())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
