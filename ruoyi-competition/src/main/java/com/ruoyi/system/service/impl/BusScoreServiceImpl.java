package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusScoreMapper;
import com.ruoyi.system.domain.BusScore;
import com.ruoyi.system.service.IBusScoreService;

/**
 * 成绩发布Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@Service
public class BusScoreServiceImpl implements IBusScoreService 
{
    @Autowired
    private BusScoreMapper busScoreMapper;

    /**
     * 查询成绩发布
     * 
     * @param scoreId 成绩发布主键
     * @return 成绩发布
     */
    @Override
    public BusScore selectBusScoreByScoreId(Long scoreId)
    {
        return busScoreMapper.selectBusScoreByScoreId(scoreId);
    }

    /**
     * 查询成绩发布列表
     * 
     * @param busScore 成绩发布
     * @return 成绩发布
     */
    @Override
    public List<BusScore> selectBusScoreList(BusScore busScore)
    {
        return busScoreMapper.selectBusScoreList(busScore);
    }

    /**
     * 新增成绩发布
     * 
     * @param busScore 成绩发布
     * @return 结果
     */
    @Override
    public int insertBusScore(BusScore busScore)
    {
        busScore.setCreateTime(DateUtils.getNowDate());
        return busScoreMapper.insertBusScore(busScore);
    }

    /**
     * 修改成绩发布
     * 
     * @param busScore 成绩发布
     * @return 结果
     */
    @Override
    public int updateBusScore(BusScore busScore)
    {
        busScore.setUpdateTime(DateUtils.getNowDate());
        return busScoreMapper.updateBusScore(busScore);
    }

    /**
     * 批量删除成绩发布
     * 
     * @param scoreIds 需要删除的成绩发布主键
     * @return 结果
     */
    @Override
    public int deleteBusScoreByScoreIds(Long[] scoreIds)
    {
        return busScoreMapper.deleteBusScoreByScoreIds(scoreIds);
    }

    /**
     * 删除成绩发布信息
     * 
     * @param scoreId 成绩发布主键
     * @return 结果
     */
    @Override
    public int deleteBusScoreByScoreId(Long scoreId)
    {
        return busScoreMapper.deleteBusScoreByScoreId(scoreId);
    }
}
