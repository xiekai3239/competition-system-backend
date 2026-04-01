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
import com.ruoyi.system.domain.BusScore;
import com.ruoyi.system.service.IBusScoreService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 成绩发布Controller
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@RestController
@RequestMapping("/system/score")
public class BusScoreController extends BaseController
{
    @Autowired
    private IBusScoreService busScoreService;

    /**
     * 查询成绩发布列表
     */
    @PreAuthorize("@ss.hasPermi('system:score:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusScore busScore)
    {
        startPage();
        List<BusScore> list = busScoreService.selectBusScoreList(busScore);
        return getDataTable(list);
    }

    /**
     * 导出成绩发布列表
     */
    @PreAuthorize("@ss.hasPermi('system:score:export')")
    @Log(title = "成绩发布", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BusScore busScore)
    {
        List<BusScore> list = busScoreService.selectBusScoreList(busScore);
        ExcelUtil<BusScore> util = new ExcelUtil<BusScore>(BusScore.class);
        util.exportExcel(response, list, "成绩发布数据");
    }

    /**
     * 获取成绩发布详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:score:query')")
    @GetMapping(value = "/{scoreId}")
    public AjaxResult getInfo(@PathVariable("scoreId") Long scoreId)
    {
        return success(busScoreService.selectBusScoreByScoreId(scoreId));
    }

    /**
     * 新增成绩发布
     */
    @PreAuthorize("@ss.hasPermi('system:score:add')")
    @Log(title = "成绩发布", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusScore busScore)
    {
        return toAjax(busScoreService.insertBusScore(busScore));
    }

    /**
     * 修改成绩发布
     */
    @PreAuthorize("@ss.hasPermi('system:score:edit')")
    @Log(title = "成绩发布", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusScore busScore)
    {
        return toAjax(busScoreService.updateBusScore(busScore));
    }

    /**
     * 删除成绩发布
     */
    @PreAuthorize("@ss.hasPermi('system:score:remove')")
    @Log(title = "成绩发布", businessType = BusinessType.DELETE)
	@DeleteMapping("/{scoreIds}")
    public AjaxResult remove(@PathVariable Long[] scoreIds)
    {
        return toAjax(busScoreService.deleteBusScoreByScoreIds(scoreIds));
    }
}
