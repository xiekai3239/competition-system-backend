package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BusReply;

/**
 * 在线讨论回复Service接口
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
public interface IBusReplyService 
{
    /**
     * 查询在线讨论回复
     * 
     * @param replyId 在线讨论回复主键
     * @return 在线讨论回复
     */
    public BusReply selectBusReplyByReplyId(Long replyId);

    /**
     * 查询在线讨论回复列表
     * 
     * @param busReply 在线讨论回复
     * @return 在线讨论回复集合
     */
    public List<BusReply> selectBusReplyList(BusReply busReply);

    /**
     * 新增在线讨论回复
     * 
     * @param busReply 在线讨论回复
     * @return 结果
     */
    public int insertBusReply(BusReply busReply);

    /**
     * 修改在线讨论回复
     * 
     * @param busReply 在线讨论回复
     * @return 结果
     */
    public int updateBusReply(BusReply busReply);

    /**
     * 批量删除在线讨论回复
     * 
     * @param replyIds 需要删除的在线讨论回复主键集合
     * @return 结果
     */
    public int deleteBusReplyByReplyIds(Long[] replyIds);

    /**
     * 删除在线讨论回复信息
     * 
     * @param replyId 在线讨论回复主键
     * @return 结果
     */
    public int deleteBusReplyByReplyId(Long replyId);
}
