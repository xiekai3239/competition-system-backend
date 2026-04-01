package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BusRegistrationMapper;
import com.ruoyi.system.domain.BusRegistration;
import com.ruoyi.system.service.IBusRegistrationService;

/**
 * 报名参赛Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@Service
public class BusRegistrationServiceImpl implements IBusRegistrationService 
{
    @Autowired
    private BusRegistrationMapper busRegistrationMapper;

    /**
     * 查询报名参赛
     * 
     * @param regId 报名参赛主键
     * @return 报名参赛
     */
    @Override
    public BusRegistration selectBusRegistrationByRegId(Long regId)
    {
        return busRegistrationMapper.selectBusRegistrationByRegId(regId);
    }

    /**
     * 查询报名参赛列表
     * 
     * @param busRegistration 报名参赛
     * @return 报名参赛
     */
    @Override
    public List<BusRegistration> selectBusRegistrationList(BusRegistration busRegistration)
    {
        return busRegistrationMapper.selectBusRegistrationList(busRegistration);
    }

    /**
     * 新增报名参赛
     * 
     * @param busRegistration 报名参赛
     * @return 结果
     */
    @Override
    public int insertBusRegistration(BusRegistration busRegistration)
    {
        busRegistration.setCreateTime(DateUtils.getNowDate());
        return busRegistrationMapper.insertBusRegistration(busRegistration);
    }

    /**
     * 修改报名参赛
     * 
     * @param busRegistration 报名参赛
     * @return 结果
     */
    @Override
    public int updateBusRegistration(BusRegistration busRegistration)
    {
        busRegistration.setUpdateTime(DateUtils.getNowDate());
        return busRegistrationMapper.updateBusRegistration(busRegistration);
    }

    /**
     * 批量删除报名参赛
     * 
     * @param regIds 需要删除的报名参赛主键
     * @return 结果
     */
    @Override
    public int deleteBusRegistrationByRegIds(Long[] regIds)
    {
        return busRegistrationMapper.deleteBusRegistrationByRegIds(regIds);
    }

    /**
     * 删除报名参赛信息
     * 
     * @param regId 报名参赛主键
     * @return 结果
     */
    @Override
    public int deleteBusRegistrationByRegId(Long regId)
    {
        return busRegistrationMapper.deleteBusRegistrationByRegId(regId);
    }
}
