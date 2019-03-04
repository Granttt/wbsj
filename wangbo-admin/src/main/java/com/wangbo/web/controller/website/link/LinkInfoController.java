package com.wangbo.web.controller.website.link;

import java.util.List;

import com.wangbo.framework.util.ShiroUtils;
import com.wangbo.website.link.entity.LinkInfo;
import com.wangbo.website.link.service.ILinkInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wangbo.common.annotation.Log;
import com.wangbo.common.enums.BusinessType;
import com.wangbo.framework.web.base.BaseController;
import com.wangbo.common.page.TableDataInfo;
import com.wangbo.common.base.AjaxResult;
import com.wangbo.common.utils.poi.ExcelUtil;

/**
 * 公司联系方式 信息操作处理
 * 
 * @author xingyu
 * @date 2019-01-14
 */
@Controller
@RequestMapping("/link/linkInfo")
public class LinkInfoController extends BaseController {
	private String prefix = "website/link/linkInfo";
	
	@Autowired
	private ILinkInfoService linkInfoService;
	
	@RequiresPermissions("link:linkInfo:view")
	@GetMapping()
	public String linkInfo()
	{
	    return prefix + "/linkInfo";
	}
	
	/**
	 * 查询公司联系方式列表
	 */
	@RequiresPermissions("link:linkInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(LinkInfo linkInfo) {
		startPage();
        List<LinkInfo> list = linkInfoService.selectLinkInfoList(linkInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出公司联系方式列表
	 */
	@RequiresPermissions("link:linkInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(LinkInfo linkInfo) {
    	List<LinkInfo> list = linkInfoService.selectLinkInfoList(linkInfo);
        ExcelUtil<LinkInfo> util = new ExcelUtil<LinkInfo>(LinkInfo.class);
        return util.exportExcel(list, "linkInfo");
    }
	
	/**
	 * 新增公司联系方式
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存公司联系方式
	 */
	@RequiresPermissions("link:linkInfo:add")
	@Log(title = "公司联系方式", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(LinkInfo linkInfo) {
		return toAjax(linkInfoService.insertLinkInfo(linkInfo));
	}

	/**
	 * 修改公司联系方式
	 */
	@GetMapping("/edit/{linkId}")
	public String edit(@PathVariable("linkId") Integer linkId, ModelMap mmap) {
		LinkInfo linkInfo = linkInfoService.selectLinkInfoById(linkId);
		mmap.put("linkInfo", linkInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存公司联系方式
	 */
	@RequiresPermissions("link:linkInfo:edit")
	@Log(title = "公司联系方式", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(LinkInfo linkInfo) {
		linkInfo.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(linkInfoService.updateLinkInfo(linkInfo));
	}
	
	/**
	 * 删除公司联系方式
	 */
	@RequiresPermissions("link:linkInfo:remove")
	@Log(title = "公司联系方式", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(linkInfoService.deleteLinkInfoByIds(ids));
	}
	
}
