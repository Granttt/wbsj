package com.wangbo.web.controller.website.menu;

import java.util.List;
import java.util.Map;

import com.wangbo.framework.util.ShiroUtils;
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
import com.wangbo.website.menu.entity.WebMenu;
import com.wangbo.website.menu.service.IWebMenuService;
import com.wangbo.framework.web.base.BaseController;
import com.wangbo.common.base.AjaxResult;
import com.wangbo.common.utils.poi.ExcelUtil;

/**
 * 网站菜单 信息操作处理
 * 
 * @author xingyu
 * @date 2019-01-25
 */
@Controller
@RequestMapping("/menu/webMenu")
public class WebMenuController extends BaseController {
    private String prefix = "website/menu/webMenu";
	
	@Autowired
	private IWebMenuService webMenuService;
	
	@RequiresPermissions("menu:webMenu:view")
	@GetMapping()
	public String webMenu()
	{
	    return prefix + "/webMenu";
	}
	
	/**
	 * 查询网站菜单列表
	 */
	@RequiresPermissions("menu:webMenu:list")
	@GetMapping("/list")
	@ResponseBody
	public List<WebMenu> list(WebMenu webMenu) {
		startPage();
        List<WebMenu> list = webMenuService.selectWebMenuList(webMenu);
		return list;
	}

	/**
	 * 导出网站菜单列表
	 */
	@RequiresPermissions("menu:webMenu:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WebMenu webMenu) {
    	List<WebMenu> list = webMenuService.selectWebMenuList(webMenu);
        ExcelUtil<WebMenu> util = new ExcelUtil<WebMenu>(WebMenu.class);
        return util.exportExcel(list, "webMenu");
    }
	
	/**
	 * 新增网站菜单
	 */
	@RequiresPermissions("menu:webMenu:add")
	@GetMapping("/add/{menuId}")
	public String add(@PathVariable("menuId") Long menuId, ModelMap mmap) {
		mmap.put("webMenu",webMenuService.selectWebMenuById(menuId));
		return prefix + "/add";
	}

	/**
	 * 新增保存网站菜单
	 */
	@RequiresPermissions("menu:webMenu:add")
	@Log(title = "网站菜单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(WebMenu webMenu) {
		webMenu.setCreateBy(ShiroUtils.getLoginName());
		return toAjax(webMenuService.insertWebMenu(webMenu));
	}

	/**
	 * 修改网站菜单
	 */
	@RequiresPermissions("proj:projCategory:edit")
	@GetMapping("/edit/{menuId}")
	public String edit(@PathVariable("menuId") Long menuId, ModelMap mmap) {
		WebMenu webMenu = webMenuService.selectWebMenuById(menuId);
		mmap.put("webMenu", webMenu);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存网站菜单
	 */
	@RequiresPermissions("menu:webMenu:edit")
	@Log(title = "网站菜单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(WebMenu webMenu) {
		webMenu.setUpdateBy(ShiroUtils.getLoginName());
		return toAjax(webMenuService.updateWebMenu(webMenu));
	}
	
	/**
	 * 删除网站菜单
	 */
	@RequiresPermissions("menu:webMenu:remove")
	@Log(title = "网站菜单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove/{menuId}")
	@ResponseBody
	public AjaxResult remove(@PathVariable("menuId") Long menuId) {
		if (webMenuService.selectWebMenuCount(menuId) > 0) {
			return error(1, "存在下级项目分类,不允许删除");
		}
		return toAjax(webMenuService.deleteWebMenuByIds(String.valueOf(menuId)));
	}

	/**
	 * 加载网站菜单列表树
	 */
	@GetMapping("/treeData")
	@ResponseBody
	public List<Map<String, Object>> treeData() {
		List<Map<String, Object>> tree = webMenuService.selectTree(new WebMenu());
		return tree;
	}

	/**
	 * 选择网站菜单树
	 */
	@GetMapping("/selectMenuTree/{menuId}")
	public String selectCategoryTree(@PathVariable("menuId") Long menuId, ModelMap mmap) {
		mmap.put("webMenu", webMenuService.selectWebMenuById(menuId));
		return prefix + "/tree";
	}
	
}
