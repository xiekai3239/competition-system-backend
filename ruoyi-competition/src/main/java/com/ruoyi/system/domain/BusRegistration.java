package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 报名参赛对象 bus_registration
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
public class BusRegistration extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 报名ID */
    private Long regId;

    /** 竞赛ID */
    @Excel(name = "竞赛ID")
    private Long compId;

    /** 申报人/队长ID（关联sys_user） */
    @Excel(name = "申报人/队长ID", readConverterExp = "关=联sys_user")
    private Long userId;

    /** 团队名称 */
    @Excel(name = "团队名称")
    private String teamName;

    /** 指导老师姓名 */
    @Excel(name = "指导老师姓名")
    private String teacherName;

    /** 团队成员信息（可存JSON或逗号分隔的学号/姓名） */
    @Excel(name = "团队成员信息", readConverterExp = "可=存JSON或逗号分隔的学号/姓名")
    private String memberInfo;

    /** 报名附件/作品文件地址 */
    @Excel(name = "报名附件/作品文件地址")
    private String regFile;

    /** 审核状态（0待审核 1通过 2驳回） */
    @Excel(name = "审核状态", readConverterExp = "0=待审核,1=通过,2=驳回")
    private String auditStatus;

    /** 审核反馈意见 */
    @Excel(name = "审核反馈意见")
    private String auditMsg;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setRegId(Long regId) 
    {
        this.regId = regId;
    }

    public Long getRegId() 
    {
        return regId;
    }

    public void setCompId(Long compId) 
    {
        this.compId = compId;
    }

    public Long getCompId() 
    {
        return compId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }

    public String getTeamName() 
    {
        return teamName;
    }

    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }

    public void setMemberInfo(String memberInfo) 
    {
        this.memberInfo = memberInfo;
    }

    public String getMemberInfo() 
    {
        return memberInfo;
    }

    public void setRegFile(String regFile) 
    {
        this.regFile = regFile;
    }

    public String getRegFile() 
    {
        return regFile;
    }

    public void setAuditStatus(String auditStatus) 
    {
        this.auditStatus = auditStatus;
    }

    public String getAuditStatus() 
    {
        return auditStatus;
    }

    public void setAuditMsg(String auditMsg) 
    {
        this.auditMsg = auditMsg;
    }

    public String getAuditMsg() 
    {
        return auditMsg;
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
            .append("regId", getRegId())
            .append("compId", getCompId())
            .append("userId", getUserId())
            .append("teamName", getTeamName())
            .append("teacherName", getTeacherName())
            .append("memberInfo", getMemberInfo())
            .append("regFile", getRegFile())
            .append("auditStatus", getAuditStatus())
            .append("auditMsg", getAuditMsg())
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
