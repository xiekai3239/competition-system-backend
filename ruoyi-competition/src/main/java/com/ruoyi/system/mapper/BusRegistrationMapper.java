package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BusRegistration;

/**
 * 报名参赛Mapper接口
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
public interface BusRegistrationMapper 
{
    /**
     * 查询报名参赛
     * 
     * @param regId 报名参赛主键
     * @return 报名参赛
     */
    public BusRegistration selectBusRegistrationByRegId(Long regId);

    /**
     * 查询报名参赛列表
     * 
     * @param busRegistration 报名参赛
     * @return 报名参赛集合
     */
    public List<BusRegistration> selectBusRegistrationList(BusRegistration busRegistration);

    /**
     * 新增报名参赛
     * 
     * @param busRegistration 报名参赛
     * @return 结果
     */
    public int insertBusRegistration(BusRegistration busRegistration);

    /**
     * 修改报名参赛
     * 
     * @param busRegistration 报名参赛
     * @return 结果
     */
    public int updateBusRegistration(BusRegistration busRegistration);

    /**
     * 删除报名参赛
     * 
     * @param regId 报名参赛主键
     * @return 结果
     */
    public int deleteBusRegistrationByRegId(Long regId);

    /**
     * 批量删除报名参赛
     * 
     * @param regIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBusRegistrationByRegIds(Long[] regIds);
}
