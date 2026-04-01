package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusDiscussionMapper;
import com.ruoyi.system.domain.BusDiscussion;
import com.ruoyi.system.service.IBusDiscussionService;

/**
 * 在线讨论主题Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@Service
public class BusDiscussionServiceImpl implements IBusDiscussionService 
{
    @Autowired
    private BusDiscussionMapper busDiscussionMapper;

    /**
     * 查询在线讨论主题
     * 
     * @param postId 在线讨论主题主键
     * @return 在线讨论主题
     */
    @Override
    public BusDiscussion selectBusDiscussionByPostId(Long postId)
    {
        return busDiscussionMapper.selectBusDiscussionByPostId(postId);
    }

    /**
     * 查询在线讨论主题列表
     * 
     * @param busDiscussion 在线讨论主题
     * @return 在线讨论主题
     */
    @Override
    public List<BusDiscussion> selectBusDiscussionList(BusDiscussion busDiscussion)
    {
        return busDiscussionMapper.selectBusDiscussionList(busDiscussion);
    }

    /**
     * 新增在线讨论主题
     * 
     * @param busDiscussion 在线讨论主题
     * @return 结果
     */
    @Override
    public int insertBusDiscussion(BusDiscussion busDiscussion)
    {
        busDiscussion.setCreateTime(DateUtils.getNowDate());
        return busDiscussionMapper.insertBusDiscussion(busDiscussion);
    }

    /**
     * 修改在线讨论主题
     * 
     * @param busDiscussion 在线讨论主题
     * @return 结果
     */
    @Override
    public int updateBusDiscussion(BusDiscussion busDiscussion)
    {
        busDiscussion.setUpdateTime(DateUtils.getNowDate());
        return busDiscussionMapper.updateBusDiscussion(busDiscussion);
    }

    /**
     * 批量删除在线讨论主题
     * 
     * @param postIds 需要删除的在线讨论主题主键
     * @return 结果
     */
    @Override
    public int deleteBusDiscussionByPostIds(Long[] postIds)
    {
        return busDiscussionMapper.deleteBusDiscussionByPostIds(postIds);
    }

    /**
     * 删除在线讨论主题信息
     * 
     * @param postId 在线讨论主题主键
     * @return 结果
     */
    @Override
    public int deleteBusDiscussionByPostId(Long postId)
    {
        return busDiscussionMapper.deleteBusDiscussionByPostId(postId);
    }
}
