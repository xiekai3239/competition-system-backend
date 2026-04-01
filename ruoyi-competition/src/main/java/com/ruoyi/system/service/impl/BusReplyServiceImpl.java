package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusReplyMapper;
import com.ruoyi.system.domain.BusReply;
import com.ruoyi.system.service.IBusReplyService;

/**
 * 在线讨论回复Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@Service
public class BusReplyServiceImpl implements IBusReplyService 
{
    @Autowired
    private BusReplyMapper busReplyMapper;

    /**
     * 查询在线讨论回复
     * 
     * @param replyId 在线讨论回复主键
     * @return 在线讨论回复
     */
    @Override
    public BusReply selectBusReplyByReplyId(Long replyId)
    {
        return busReplyMapper.selectBusReplyByReplyId(replyId);
    }

    /**
     * 查询在线讨论回复列表
     * 
     * @param busReply 在线讨论回复
     * @return 在线讨论回复
     */
    @Override
    public List<BusReply> selectBusReplyList(BusReply busReply)
    {
        return busReplyMapper.selectBusReplyList(busReply);
    }

    /**
     * 新增在线讨论回复
     * 
     * @param busReply 在线讨论回复
     * @return 结果
     */
    @Override
    public int insertBusReply(BusReply busReply)
    {
        busReply.setCreateTime(DateUtils.getNowDate());
        return busReplyMapper.insertBusReply(busReply);
    }

    /**
     * 修改在线讨论回复
     * 
     * @param busReply 在线讨论回复
     * @return 结果
     */
    @Override
    public int updateBusReply(BusReply busReply)
    {
        busReply.setUpdateTime(DateUtils.getNowDate());
        return busReplyMapper.updateBusReply(busReply);
    }

    /**
     * 批量删除在线讨论回复
     * 
     * @param replyIds 需要删除的在线讨论回复主键
     * @return 结果
     */
    @Override
    public int deleteBusReplyByReplyIds(Long[] replyIds)
    {
        return busReplyMapper.deleteBusReplyByReplyIds(replyIds);
    }

    /**
     * 删除在线讨论回复信息
     * 
     * @param replyId 在线讨论回复主键
     * @return 结果
     */
    @Override
    public int deleteBusReplyByReplyId(Long replyId)
    {
        return busReplyMapper.deleteBusReplyByReplyId(replyId);
    }
}
