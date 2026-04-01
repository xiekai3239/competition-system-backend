package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusCompetitionMapper;
import com.ruoyi.system.domain.BusCompetition;
import com.ruoyi.system.service.IBusCompetitionService;

/**
 * 竞赛信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@Service
public class BusCompetitionServiceImpl implements IBusCompetitionService 
{
    @Autowired
    private BusCompetitionMapper busCompetitionMapper;

    /**
     * 查询竞赛信息
     * 
     * @param compId 竞赛信息主键
     * @return 竞赛信息
     */
    @Override
    public BusCompetition selectBusCompetitionByCompId(Long compId)
    {
        return busCompetitionMapper.selectBusCompetitionByCompId(compId);
    }

    /**
     * 查询竞赛信息列表
     * 
     * @param busCompetition 竞赛信息
     * @return 竞赛信息
     */
    @Override
    public List<BusCompetition> selectBusCompetitionList(BusCompetition busCompetition)
    {
        return busCompetitionMapper.selectBusCompetitionList(busCompetition);
    }

    /**
     * 新增竞赛信息
     * 
     * @param busCompetition 竞赛信息
     * @return 结果
     */
    @Override
    public int insertBusCompetition(BusCompetition busCompetition)
    {
        busCompetition.setCreateTime(DateUtils.getNowDate());
        return busCompetitionMapper.insertBusCompetition(busCompetition);
    }

    /**
     * 修改竞赛信息
     * 
     * @param busCompetition 竞赛信息
     * @return 结果
     */
    @Override
    public int updateBusCompetition(BusCompetition busCompetition)
    {
        busCompetition.setUpdateTime(DateUtils.getNowDate());
        return busCompetitionMapper.updateBusCompetition(busCompetition);
    }

    /**
     * 批量删除竞赛信息
     * 
     * @param compIds 需要删除的竞赛信息主键
     * @return 结果
     */
    @Override
    public int deleteBusCompetitionByCompIds(Long[] compIds)
    {
        return busCompetitionMapper.deleteBusCompetitionByCompIds(compIds);
    }

    /**
     * 删除竞赛信息信息
     * 
     * @param compId 竞赛信息主键
     * @return 结果
     */
    @Override
    public int deleteBusCompetitionByCompId(Long compId)
    {
        return busCompetitionMapper.deleteBusCompetitionByCompId(compId);
    }
}
