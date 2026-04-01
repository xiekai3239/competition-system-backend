package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.BusCompetition;
import com.ruoyi.system.service.IBusCompetitionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 竞赛信息Controller
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@RestController
@RequestMapping("/system/competition")
public class BusCompetitionController extends BaseController
{
    @Autowired
    private IBusCompetitionService busCompetitionService;

    /**
     * 查询竞赛信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:competition:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusCompetition busCompetition)
    {
        startPage();
        List<BusCompetition> list = busCompetitionService.selectBusCompetitionList(busCompetition);
        return getDataTable(list);
    }

    /**
     * 导出竞赛信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:competition:export')")
    @Log(title = "竞赛信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BusCompetition busCompetition)
    {
        List<BusCompetition> list = busCompetitionService.selectBusCompetitionList(busCompetition);
        ExcelUtil<BusCompetition> util = new ExcelUtil<BusCompetition>(BusCompetition.class);
        util.exportExcel(response, list, "竞赛信息数据");
    }

    /**
     * 获取竞赛信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:competition:query')")
    @GetMapping(value = "/{compId}")
    public AjaxResult getInfo(@PathVariable("compId") Long compId)
    {
        return success(busCompetitionService.selectBusCompetitionByCompId(compId));
    }

    /**
     * 新增竞赛信息
     */
    @PreAuthorize("@ss.hasPermi('system:competition:add')")
    @Log(title = "竞赛信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusCompetition busCompetition)
    {
        return toAjax(busCompetitionService.insertBusCompetition(busCompetition));
    }

    /**
     * 修改竞赛信息
     */
    @PreAuthorize("@ss.hasPermi('system:competition:edit')")
    @Log(title = "竞赛信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusCompetition busCompetition)
    {
        return toAjax(busCompetitionService.updateBusCompetition(busCompetition));
    }

    /**
     * 删除竞赛信息
     */
    @PreAuthorize("@ss.hasPermi('system:competition:remove')")
    @Log(title = "竞赛信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{compIds}")
    public AjaxResult remove(@PathVariable Long[] compIds)
    {
        return toAjax(busCompetitionService.deleteBusCompetitionByCompIds(compIds));
    }
}
