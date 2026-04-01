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
import com.ruoyi.system.domain.BusReply;
import com.ruoyi.system.service.IBusReplyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 在线讨论回复Controller
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@RestController
@RequestMapping("/system/reply")
public class BusReplyController extends BaseController
{
    @Autowired
    private IBusReplyService busReplyService;

    /**
     * 查询在线讨论回复列表
     */
    @PreAuthorize("@ss.hasPermi('system:reply:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusReply busReply)
    {
        startPage();
        List<BusReply> list = busReplyService.selectBusReplyList(busReply);
        return getDataTable(list);
    }

    /**
     * 导出在线讨论回复列表
     */
    @PreAuthorize("@ss.hasPermi('system:reply:export')")
    @Log(title = "在线讨论回复", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BusReply busReply)
    {
        List<BusReply> list = busReplyService.selectBusReplyList(busReply);
        ExcelUtil<BusReply> util = new ExcelUtil<BusReply>(BusReply.class);
        util.exportExcel(response, list, "在线讨论回复数据");
    }

    /**
     * 获取在线讨论回复详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:reply:query')")
    @GetMapping(value = "/{replyId}")
    public AjaxResult getInfo(@PathVariable("replyId") Long replyId)
    {
        return success(busReplyService.selectBusReplyByReplyId(replyId));
    }

    /**
     * 新增在线讨论回复
     */
    @PreAuthorize("@ss.hasPermi('system:reply:add')")
    @Log(title = "在线讨论回复", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusReply busReply)
    {
        return toAjax(busReplyService.insertBusReply(busReply));
    }

    /**
     * 修改在线讨论回复
     */
    @PreAuthorize("@ss.hasPermi('system:reply:edit')")
    @Log(title = "在线讨论回复", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusReply busReply)
    {
        return toAjax(busReplyService.updateBusReply(busReply));
    }

    /**
     * 删除在线讨论回复
     */
    @PreAuthorize("@ss.hasPermi('system:reply:remove')")
    @Log(title = "在线讨论回复", businessType = BusinessType.DELETE)
	@DeleteMapping("/{replyIds}")
    public AjaxResult remove(@PathVariable Long[] replyIds)
    {
        return toAjax(busReplyService.deleteBusReplyByReplyIds(replyIds));
    }
}
