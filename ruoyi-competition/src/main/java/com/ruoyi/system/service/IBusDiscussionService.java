package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BusDiscussion;

/**
 * 在线讨论主题Service接口
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
public interface IBusDiscussionService 
{
    /**
     * 查询在线讨论主题
     * 
     * @param postId 在线讨论主题主键
     * @return 在线讨论主题
     */
    public BusDiscussion selectBusDiscussionByPostId(Long postId);

    /**
     * 查询在线讨论主题列表
     * 
     * @param busDiscussion 在线讨论主题
     * @return 在线讨论主题集合
     */
    public List<BusDiscussion> selectBusDiscussionList(BusDiscussion busDiscussion);

    /**
     * 新增在线讨论主题
     * 
     * @param busDiscussion 在线讨论主题
     * @return 结果
     */
    public int insertBusDiscussion(BusDiscussion busDiscussion);

    /**
     * 修改在线讨论主题
     * 
     * @param busDiscussion 在线讨论主题
     * @return 结果
     */
    public int updateBusDiscussion(BusDiscussion busDiscussion);

    /**
     * 批量删除在线讨论主题
     * 
     * @param postIds 需要删除的在线讨论主题主键集合
     * @return 结果
     */
    public int deleteBusDiscussionByPostIds(Long[] postIds);

    /**
     * 删除在线讨论主题信息
     * 
     * @param postId 在线讨论主题主键
     * @return 结果
     */
    public int deleteBusDiscussionByPostId(Long postId);
}
