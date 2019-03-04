package com.wangbo.api.entity;

import com.wangbo.website.menu.entity.WebMenu;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 导航栏封装
 *
 * @author xingyu
 * @date 2019/1/26
 */
@ApiModel(value = "导航栏",description="导航栏MenuEntiry")
public class MenuEntiry {
    /**
     * 菜单ID
     */
    @ApiModelProperty(value="菜单ID",example ="513513")
    private Long menuId;
    /**
     * 菜单名称
     */
    @ApiModelProperty(value="菜单名称",example ="首页")
    private String menuName;
    /**
     * URL
     */
    @ApiModelProperty(value="URL",example ="index.html")
    private String menuUrl;
    /**
     * 标识
     */
    @ApiModelProperty(value="标识",example ="index")
    private String menuKey;
    /**
     * 菜单类型
     */
    @ApiModelProperty(value="菜单类型",example ="1")
    private String menuType;
    /**
     * 显示顺序
     */
    @ApiModelProperty(value="显示顺序",example ="1")
    private Long orderNum;
    /**
     * 状态（0正常 1停用）
     */
    @ApiModelProperty(value="状态",example ="0")
    private String status;
    /**
     * 是否有子菜单
     */
    @ApiModelProperty(value="是否有子菜单",example ="0")
    private String isParent;
    /**
     * 子菜单
     */
    @ApiModelProperty(value="子菜单",example ="List")
    private List childMenu;

    public void setMenu(WebMenu webMenu){
        this.menuId = webMenu.getMenuId();
        this.menuName = webMenu.getMenuName();
        this.menuUrl = webMenu.getMenuUrl();
        this.menuKey = webMenu.getMenuKey();
        this.menuType = webMenu.getMenuType();
        this.status = webMenu.getStatus();
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Long getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Long orderNum) {
        this.orderNum = orderNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsParent() {
        return isParent;
    }

    public void setIsParent(String isParent) {
        this.isParent = isParent;
    }

    public List getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List childMenu) {
        this.childMenu = childMenu;
    }
}

