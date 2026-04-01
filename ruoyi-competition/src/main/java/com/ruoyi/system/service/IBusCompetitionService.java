package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BusCompetition;

/**
 * 竞赛信息Service接口
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
public interface IBusCompetitionService 
{
    /**
     * 查询竞赛信息
     * 
     * @param compId 竞赛信息主键
     * @return 竞赛信息
     */
    public BusCompetition selectBusCompetitionByCompId(Long compId);

    /**
     * 查询竞赛信息列表
     * 
     * @param busCompetition 竞赛信息
     * @return 竞赛信息集合
     */
    public List<BusCompetition> selectBusCompetitionList(BusCompetition busCompetition);

    /**
     * 新增竞赛信息
     * 
     * @param busCompetition 竞赛信息
     * @return 结果
     */
    public int insertBusCompetition(BusCompetition busCompetition);

    /**
     * 修改竞赛信息
     * 
     * @param busCompetition 竞赛信息
     * @return 结果
     */
    public int updateBusCompetition(BusCompetition busCompetition);

    /**
     * 批量删除竞赛信息
     * 
     * @param compIds 需要删除的竞赛信息主键集合
     * @return 结果
     */
    public int deleteBusCompetitionByCompIds(Long[] compIds);

    /**
     * 删除竞赛信息信息
     * 
     * @param compId 竞赛信息主键
     * @return 结果
     */
    public int deleteBusCompetitionByCompId(Long compId);
}
