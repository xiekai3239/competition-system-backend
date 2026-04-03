package com.ruoyi.system.controller;

import com.ruoyi.common.utils.SecurityUtils;
import java.util.List;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BusRegistration;
import com.ruoyi.system.service.IBusRegistrationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报名参赛Controller
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@RestController
@RequestMapping("/system/registration")
public class BusRegistrationController extends BaseController
{
    @Autowired
    private IBusRegistrationService busRegistrationService;

    /**
     * 查询报名参赛列表
     */
    @PreAuthorize("@ss.hasPermi('system:registration:list')") // 注意这里的权限标识根据你的实际菜单修改
    @GetMapping("/list")
    public TableDataInfo list(BusRegistration busRegistration)
    {
        // 【核心改造】：数据隔离。如果当前登录人不是超级管理员，则强制要求只能查询自己的报名记录
        if (!SecurityUtils.isAdmin(SecurityUtils.getUserId())) {
            busRegistration.setUserId(SecurityUtils.getUserId());
        }
        startPage();
        List<BusRegistration> list = busRegistrationService.selectBusRegistrationList(busRegistration);
        return getDataTable(list);
    }

    /**
     * 导出报名参赛列表
     */
    @PreAuthorize("@ss.hasPermi('system:registration:export')")
    @Log(title = "报名参赛", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BusRegistration busRegistration)
    {
        List<BusRegistration> list = busRegistrationService.selectBusRegistrationList(busRegistration);
        ExcelUtil<BusRegistration> util = new ExcelUtil<BusRegistration>(BusRegistration.class);
        util.exportExcel(response, list, "报名参赛数据");
    }

    /**
     * 获取报名参赛详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:registration:query')")
    @GetMapping(value = "/{regId}")
    public AjaxResult getInfo(@PathVariable("regId") Long regId)
    {
        return success(busRegistrationService.selectBusRegistrationByRegId(regId));
    }

    /**
     * 新增报名参赛
     */
    @PreAuthorize("@ss.hasPermi('system:registration:add')")
    @Log(title = "报名参赛", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusRegistration busRegistration)
    {
        busRegistration.setUserId(SecurityUtils.getUserId());
        busRegistration.setCreateBy(SecurityUtils.getUsername());
        return toAjax(busRegistrationService.insertBusRegistration(busRegistration));
    }

    /**
     * 修改报名参赛
     */
    @PreAuthorize("@ss.hasPermi('system:registration:edit')")
    @Log(title = "报名参赛", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusRegistration busRegistration)
    {
        return toAjax(busRegistrationService.updateBusRegistration(busRegistration));
    }

    /**
     * 删除报名参赛
     */
    @PreAuthorize("@ss.hasPermi('system:registration:remove')")
    @Log(title = "报名参赛", businessType = BusinessType.DELETE)
	@DeleteMapping("/{regIds}")
    public AjaxResult remove(@PathVariable Long[] regIds)
    {
        return toAjax(busRegistrationService.deleteBusRegistrationByRegIds(regIds));
    }
}
