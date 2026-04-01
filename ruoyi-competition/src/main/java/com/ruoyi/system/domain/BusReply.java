package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 在线讨论回复对象 bus_reply
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
public class BusReply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 回复ID */
    private Long replyId;

    /** 帖子ID */
    @Excel(name = "帖子ID")
    private Long postId;

    /** 父回复ID（0代表直接回复主帖） */
    @Excel(name = "父回复ID", readConverterExp = "0=代表直接回复主帖")
    private Long parentId;

    /** 回复人ID */
    @Excel(name = "回复人ID")
    private Long userId;

    /** 回复内容 */
    @Excel(name = "回复内容")
    private String content;

    /** 状态（0正常 1隐藏） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=隐藏")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setReplyId(Long replyId) 
    {
        this.replyId = replyId;
    }

    public Long getReplyId() 
    {
        return replyId;
    }

    public void setPostId(Long postId) 
    {
        this.postId = postId;
    }

    public Long getPostId() 
    {
        return postId;
    }

    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
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
            .append("replyId", getReplyId())
            .append("postId", getPostId())
            .append("parentId", getParentId())
            .append("userId", getUserId())
            .append("content", getContent())
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
