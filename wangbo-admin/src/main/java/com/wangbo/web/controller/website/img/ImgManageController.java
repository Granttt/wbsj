package com.wangbo.web.controller.website.img;

import java.util.Date;
import java.util.List;

import com.wangbo.framework.util.ShiroUtils;
import com.wangbo.website.menu.service.IWebMenuService;
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
import com.wangbo.website.img.entity.ImgManage;
import com.wangbo.website.img.service.IImgManageService;
import com.wangbo.framework.web.base.BaseController;
import com.wangbo.common.page.TableDataInfo;
import com.wangbo.common.base.AjaxResult;
import com.wangbo.common.utils.poi.ExcelUtil;

/**
 * 图片管理 信息操作处理
 * 
 * @author xingyu
 * @date 2019-01-12
 */
@Controller
@RequestMapping("/img/imgManage")
public class ImgManageController extends BaseController {
    private String prefix = "website/img/imgManage";
	
	@Autowired
	private IImgManageService imgManageService;
	@Autowired
	private IWebMenuService webMenuService;
	
	@RequiresPermissions("img:imgManage:view")
	@GetMapping()
	public String imgManage()
	{
	    return prefix + "/imgInfoTree";
	}
	
	/**
	 * 查询图片管理列表
	 */
	@RequiresPermissions("img:imgManage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(ImgManage imgManage) {
		startPage();
        List<ImgManage> list = imgManageService.selectImgManageList(imgManage);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出图片管理列表
	 */
	@RequiresPermissions("img:imgManage:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ImgManage imgManage) {
    	List<ImgManage> list = imgManageService.selectImgManageList(imgManage);
        ExcelUtil<ImgManage> util = new ExcelUtil<ImgManage>(ImgManage.class);
        return util.exportExcel(list, "imgManage");
    }
	
	/**
	 * 新增图片管理
	 */
	@RequiresPermissions("img:imgManage:add")
	@GetMapping("/add/{menuId}")
	public String add(@PathVariable("menuId") Long menuId, ModelMap mmap) {
		mmap.put("webMenu",webMenuService.selectWebMenuById(menuId));
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存图片管理
	 */
	@RequiresPermissions("img:imgManage:add")
	@Log(title = "图片管理", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(ImgManage imgManage) {
		imgManage.setCreateBy(ShiroUtils.getLoginName());
		imgManage.setCreateTime(new Date());
		return toAjax(imgManageService.insertImgManage(imgManage));
	}

	/**
	 * 修改图片管理
	 */
	@GetMapping("/edit/{imgId}")
	public String edit(@PathVariable("imgId") Long imgId, ModelMap mmap) {
		ImgManage imgManage = imgManageService.selectImgManageById(imgId);
		mmap.put("imgManage", imgManage);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存图片管理
	 */
	@RequiresPermissions("img:imgManage:edit")
	@Log(title = "图片管理", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(ImgManage imgManage) {
		imgManage.setUpdateBy(ShiroUtils.getLoginName());
		imgManage.setUpdateTime(new Date());
		return toAjax(imgManageService.updateImgManage(imgManage));
	}
	
	/**
	 * 删除图片管理
	 */
	@RequiresPermissions("img:imgManage:remove")
	@Log(title = "图片管理", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(imgManageService.deleteImgManageByIds(ids));
	}
	
}
