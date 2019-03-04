package com.wangbo.api.controller;

import com.wangbo.api.entity.MenuEntiry;
import com.wangbo.api.utils.R;
import com.wangbo.website.menu.entity.WebMenu;
import com.wangbo.website.menu.service.IWebMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 导航栏Api
 *
 * @author xingyu
 * @date 2019/1/26
 */
@Api("导航栏接口")
@RestController
@RequestMapping("/api/menu")
public class MenuApiController {
    /**
     * 日志对象
     **/
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IWebMenuService webMenuService;

    @ApiOperation(value="获取获取导航栏",notes="获取导航栏")
    @GetMapping(value = "/info")
    public R get() {
        WebMenu webMenu = new WebMenu();
        webMenu.setParentId(1L);
        webMenu.setStatus("0");
        //查询一级菜单列表
        List<WebMenu> menuList = webMenuService.selectWebMenuList(webMenu);
        List<MenuEntiry> menuEntiryList = new ArrayList<>();
        if(menuList.size()>0){
            for(WebMenu webMenu1 : menuList){
                //一级菜单
                MenuEntiry menuEntiry = new MenuEntiry();
                menuEntiry.setMenu(webMenu1);
                List<WebMenu> childMenuList = webMenuService.selectWebMenuChild(webMenu1);
                if(childMenuList.size()>0){
                    List<MenuEntiry> menuEntiryList2 = new ArrayList<>();
                    for(WebMenu webMenu2 : childMenuList){
                        //二级菜单
                        MenuEntiry menuEntiry2 = new MenuEntiry();
                        menuEntiry2.setMenu(webMenu2);
                        menuEntiryList2.add(menuEntiry2);
                    }
                    menuEntiry.setIsParent("1");
                    menuEntiry.setChildMenu(menuEntiryList2);
                }else{
                    menuEntiry.setIsParent("0");
                }
                menuEntiryList.add(menuEntiry);
            }
            return R.ok("200","200",menuEntiryList);
        }else{
            return R.error("500","没有数据");
        }
    }

    @ApiOperation(value="获取导航栏列表",notes="根据导航栏的id来获取子菜单列表")
    @ApiImplicitParam(name = "parentId", value = "导航ID", dataType = "Long")
    @GetMapping("getMenuList")
    public R getMenuList(@RequestParam Long parentId){
        List<WebMenu> menuList = webMenuService.selectWebMenuByParent(parentId);
        if(menuList.size()>0){
            return R.ok("200","返回成功",menuList);
        }else{
            return R.error("500","没有数据");
        }

    }

    @ApiOperation(value="获取标签栏列表",notes="根据导航栏的id来获取标签栏列表")
    @ApiImplicitParam(name = "parentId", value = "导航ID", dataType = "Long")
    @GetMapping("getTagList")
    public R getTagList(@RequestParam Long parentId){
        List<WebMenu> menuList = webMenuService.selectWebMenuTag(parentId);
        if(menuList.size()>0){
            return R.ok("200","返回成功",menuList);
        }else{
            return R.error("500","没有数据");
        }
    }
}

