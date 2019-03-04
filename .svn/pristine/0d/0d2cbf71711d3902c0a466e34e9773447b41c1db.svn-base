package com.wangbo.api.controller;

import com.wangbo.api.utils.R;
import com.wangbo.website.img.entity.ImgManage;
import com.wangbo.website.img.service.IImgManageService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 图片接口
 *
 * @author : 纪昊天
 * @version : 1.0.0
 * @date : 2019/1/25 16:40
 */
@RestController
@RequestMapping("/api/img")
public class ImgApiController {
    @Autowired
    private IImgManageService imgManageService;

    @ApiOperation(value="获取图片列表",notes="根据导航栏的id及使用用途来获取指定信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "menuId", value = "导航栏ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "imageSort", value = "用途（B-轮播,J-选项卡介绍,L-列表,P-拼图,F-底部循环,Q-其他）", required = true, dataType = "String")
    })
    @GetMapping("getImgList")
    public R getProjectList(@RequestParam  Long menuId, @RequestParam  String imageSort){
        ImgManage imgManage = new ImgManage();
        imgManage.setMenuId(menuId);
        imgManage.setImageSort(imageSort);
        imgManage.setStatus("0");
        List<ImgManage> imgManageList = imgManageService.selectImgManageList(imgManage);
        if(imgManageList.size()>0){
            return R.ok("200","返回成功",imgManageList);
        }else{
            return R.error("500","没有数据");
        }

    }
}
