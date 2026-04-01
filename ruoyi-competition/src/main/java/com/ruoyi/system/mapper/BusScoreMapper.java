package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BusScore;

/**
 * 成绩发布Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
public interface BusScoreMapper 
{
    /**
     * 查询成绩发布
     * 
     * @param scoreId 成绩发布主键
     * @return 成绩发布
     */
    public BusScore selectBusScoreByScoreId(Long scoreId);

    /**
     * 查询成绩发布列表
     * 
     * @param busScore 成绩发布
     * @return 成绩发布集合
     */
    public List<BusScore> selectBusScoreList(BusScore busScore);

    /**
     * 新增成绩发布
     * 
     * @param busScore 成绩发布
     * @return 结果
     */
    public int insertBusScore(BusScore busScore);

    /**
     * 修改成绩发布
     * 
     * @param busScore 成绩发布
     * @return 结果
     */
    public int updateBusScore(BusScore busScore);

    /**
     * 删除成绩发布
     * 
     * @param scoreId 成绩发布主键
     * @return 结果
     */
    public int deleteBusScoreByScoreId(Long scoreId);

    /**
     * 批量删除成绩发布
     * 
     * @param scoreIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBusScoreByScoreIds(Long[] scoreIds);
}
