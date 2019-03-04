package com.wangbo.api.controller;

import com.wangbo.api.utils.R;
import com.wangbo.website.proj.entity.ProjInfo;
import com.wangbo.website.proj.service.IProjInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 项目案例API
 *
 * @author xingyu
 * @date 2019/1/16
 */
@RestController
@RequestMapping("/api/project")
public class ProjectApiController {
    @Autowired
    private IProjInfoService projInfoService;

    @ApiOperation(value="获取项目列表",notes = "根据导航栏ID获取项目列表")
    @ApiImplicitParam(name = "menuId", value = "选项卡ID", dataType = "Long")
    @GetMapping("getProjectList")
    public R getProjectList(@RequestParam Long menuId){
        ProjInfo projInfo = new ProjInfo();
        projInfo.setMenuId(menuId);
        List<ProjInfo> projInfoList = projInfoService.selectProjInfoList(projInfo);
        if(projInfoList.size()>0){
            return R.ok("200","返回成功",projInfoList);
        }else{
            return R.error("500","没有数据");
        }

    }

    @ApiOperation(value="获取项目详情",notes = "根据ID获取详情")
    @ApiImplicitParam(name = "projectId", value = "项目ID", dataType = "String")
    @GetMapping("getProjectInfo")
    public R getProjectInfo(@RequestParam String projectId){
        ProjInfo projInfo = projInfoService.selectProjInfoById(projectId);
       if(null != projInfo){
           return R.ok("200","返回成功",projInfo);
       }else {
           return R.error("500","没有数据");
       }
    }

//    @ApiOperation(value="经典项目",notes = "根据menuID经典项目")
//    @ApiImplicitParam(name = "menuId", value = "导航栏ID", dataType = "Long")
//    @GetMapping("getTypicalProjectList")
//    public R getTypicalProjectList(@RequestParam  Long menuId){
//        ProjInfo projInfo = new ProjInfo();
//        projInfo.setMenuId(menuId);
//        projInfo.setTypical("Y");
//        List<ProjInfo> projInfoList = projInfoService.selectProjInfoList(projInfo);
//        if(projInfoList.size()>0){
//            return R.ok("200","返回成功",projInfoList);
//        }else {
//            return R.error("500","没有数据");
//        }
//
//    }
}

