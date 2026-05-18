package com.ruoyi.system.service.impl;

import java.math.BigDecimal;
import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusScoreMapper;
import com.ruoyi.system.domain.BusCompetition;
import com.ruoyi.system.domain.BusRegistration;
import com.ruoyi.system.domain.BusScore;
import com.ruoyi.system.domain.BusScoreStatistics;
import com.ruoyi.system.service.IBusScoreService;
import com.ruoyi.system.service.IBusCompetitionService;
import com.ruoyi.system.service.IBusRegistrationService;

/**
 * 成绩发布Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@Service
public class BusScoreServiceImpl implements IBusScoreService {
    @Autowired
    private BusScoreMapper busScoreMapper;
    
    @Autowired
    private IBusCompetitionService busCompetitionService;
    
    @Autowired
    private IBusRegistrationService busRegistrationService;

    /**
     * 查询成绩发布
     * 
     * @param scoreId 成绩发布主键
     * @return 成绩发布
     */
    @Override
    public BusScore selectBusScoreByScoreId(Long scoreId) {
        return busScoreMapper.selectBusScoreByScoreId(scoreId);
    }

    /**
     * 查询成绩发布列表
     * 
     * @param busScore 成绩发布
     * @return 成绩发布
     */
    @Override
    public List<BusScore> selectBusScoreList(BusScore busScore) {
        return busScoreMapper.selectBusScoreList(busScore);
    }

    /**
     * 新增成绩发布
     * 
     * @param busScore 成绩发布
     * @return 结果
     */
    @Override
    public int insertBusScore(BusScore busScore) {
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
    public int updateBusScore(BusScore busScore) {
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
    public int deleteBusScoreByScoreIds(Long[] scoreIds) {
        return busScoreMapper.deleteBusScoreByScoreIds(scoreIds);
    }

    /**
     * 删除成绩发布信息
     * 
     * @param scoreId 成绩发布主键
     * @return 结果
     */
    @Override
    public int deleteBusScoreByScoreId(Long scoreId) {
        return busScoreMapper.deleteBusScoreByScoreId(scoreId);
    }

    /**
     * 按竞赛分组统计成绩（平均分、最高分）
     * 
     * @param busScore 成绩发布
     * @return 成绩统计集合
     */
    @Override
    public List<BusScoreStatistics> selectScoreStatisticsByComp(BusScore busScore) {
        return busScoreMapper.selectScoreStatisticsByComp(busScore);
    }

    /**
     * 导入成绩数据
     * 
     * @param scoreList 成绩列表
     * @param updateSupport 是否更新已存在的数据
     * @return 导入结果信息
     */
    @Override
    public String importScoreData(List<BusScore> scoreList, boolean updateSupport) {
        if (scoreList == null || scoreList.isEmpty()) {
            return "导入数据不能为空";
        }
        
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        
        for (BusScore score : scoreList) {
            try {
                // 通过竞赛名称查找竞赛ID
                if (StringUtils.isNotEmpty(score.getCompName()) && score.getCompId() == null) {
                    BusCompetition compQuery = new BusCompetition();
                    compQuery.setCompName(score.getCompName());
                    List<BusCompetition> compList = busCompetitionService.selectBusCompetitionList(compQuery);
                    if (compList != null && !compList.isEmpty()) {
                        score.setCompId(compList.get(0).getCompId());
                    } else {
                        failureNum++;
                        failureMsg.append("<br/>").append(failureNum).append("、竞赛名称【").append(score.getCompName()).append("】不存在");
                        continue;
                    }
                }
                
                // 通过队伍名称查找报名ID
                if (StringUtils.isNotEmpty(score.getTeamName()) && score.getRegId() == null) {
                    BusRegistration regQuery = new BusRegistration();
                    regQuery.setTeamName(score.getTeamName());
                    // 如果同时有竞赛名称，加上竞赛ID过滤
                    if (score.getCompId() != null) {
                        regQuery.setCompId(score.getCompId());
                    }
                    List<BusRegistration> regList = busRegistrationService.selectBusRegistrationList(regQuery);
                    if (regList != null && !regList.isEmpty()) {
                        score.setRegId(regList.get(0).getRegId());
                    } else {
                        failureNum++;
                        failureMsg.append("<br/>").append(failureNum).append("、队伍名称【").append(score.getTeamName()).append("】不存在");
                        continue;
                    }
                }
                
                // 验证必填字段
                if (score.getCompId() == null) {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("、竞赛不能为空");
                    continue;
                }
                if (score.getRegId() == null) {
                    failureNum++;
                    failureMsg.append("<br/>").append(failureNum).append("、报名队伍不能为空");
                    continue;
                }
                
                // 检查是否已存在（根据compId和regId）
                BusScore query = new BusScore();
                query.setCompId(score.getCompId());
                query.setRegId(score.getRegId());
                List<BusScore> existingList = busScoreMapper.selectBusScoreList(query);
                
                if (!existingList.isEmpty()) {
                    if (updateSupport) {
                        // 更新已有记录
                        BusScore existing = existingList.get(0);
                        score.setScoreId(existing.getScoreId());
                        score.setUpdateTime(DateUtils.getNowDate());
                        busScoreMapper.updateBusScore(score);
                        successNum++;
                        successMsg.append("<br/>").append(successNum).append("、成绩已更新");
                    } else {
                        failureNum++;
                        failureMsg.append("<br/>").append(failureNum).append("、成绩已存在");
                    }
                } else {
                    // 新增记录
                    score.setCreateTime(DateUtils.getNowDate());
                    score.setDelFlag("0");
                    score.setStatus("0");
                    if (StringUtils.isEmpty(score.getIsPublish())) {
                        score.setIsPublish("0");
                    }
                    busScoreMapper.insertBusScore(score);
                    successNum++;
                    successMsg.append("<br/>").append(successNum).append("、成绩导入成功");
                }
            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、导入失败：" + e.getMessage();
                failureMsg.append(msg);
            }
        }
        
        if (failureNum > 0) {
            failureMsg.insert(0, "共" + failureNum + "条数据导入失败：");
        }
        if (successNum > 0) {
            successMsg.insert(0, "共" + successNum + "条数据导入成功：");
        } else {
            successMsg.append("没有成功导入的数据");
        }
        
        return successMsg + (failureNum > 0 ? "<br/>" + failureMsg : "");
    }
}
