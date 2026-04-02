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
import com.ruoyi.system.domain.BusDiscussion;
import com.ruoyi.system.service.IBusDiscussionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 在线讨论主题Controller
 * 
 * @author ruoyi
 * @date 2026-03-31
 */
@RestController
@RequestMapping("/system/discussion")
public class BusDiscussionController extends BaseController
{
    @Autowired
    private IBusDiscussionService busDiscussionService;

    /**
     * 查询在线讨论主题列表
     */
    @PreAuthorize("@ss.hasPermi('system:discussion:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusDiscussion busDiscussion)
    {
        startPage();
        List<BusDiscussion> list = busDiscussionService.selectBusDiscussionList(busDiscussion);
        return getDataTable(list);
    }

    /**
     * 导出在线讨论主题列表
     */
    @PreAuthorize("@ss.hasPermi('system:discussion:export')")
    @Log(title = "在线讨论主题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BusDiscussion busDiscussion)
    {
        List<BusDiscussion> list = busDiscussionService.selectBusDiscussionList(busDiscussion);
        ExcelUtil<BusDiscussion> util = new ExcelUtil<BusDiscussion>(BusDiscussion.class);
        util.exportExcel(response, list, "在线讨论主题数据");
    }

    /**
     * 获取在线讨论主题详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:discussion:query')")
    @GetMapping(value = "/{postId}")
    public AjaxResult getInfo(@PathVariable("postId") Long postId)
    {
        BusDiscussion discussion = busDiscussionService.selectBusDiscussionByPostId(postId);
        // 每次查看详情，浏览量 +1
        if(discussion != null) {
            discussion.setViewCount(discussion.getViewCount() + 1);
            busDiscussionService.updateBusDiscussion(discussion);
        }
        return success(discussion);
    }

    /**
     * 新增在线讨论主题
     */
    @PreAuthorize("@ss.hasPermi('system:discussion:add')")
    @Log(title = "在线讨论主题", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusDiscussion busDiscussion)
    {
        // 核心修复：发帖时自动绑定当前登录用户的ID
        busDiscussion.setUserId(SecurityUtils.getUserId());
        busDiscussion.setCreateBy(SecurityUtils.getUsername());

        return toAjax(busDiscussionService.insertBusDiscussion(busDiscussion));
    }
    /**
     * 修改在线讨论主题
     */
    @PreAuthorize("@ss.hasPermi('system:discussion:edit')")
    @Log(title = "在线讨论主题", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusDiscussion busDiscussion)
    {
        return toAjax(busDiscussionService.updateBusDiscussion(busDiscussion));
    }

    /**
     * 删除在线讨论主题
     */
    @PreAuthorize("@ss.hasPermi('system:discussion:remove')")
    @Log(title = "在线讨论主题", businessType = BusinessType.DELETE)
	@DeleteMapping("/{postIds}")
    public AjaxResult remove(@PathVariable Long[] postIds)
    {
        return toAjax(busDiscussionService.deleteBusDiscussionByPostIds(postIds));
    }
}
