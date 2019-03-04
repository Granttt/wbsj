package com.wangbo.api.controller;

import com.wangbo.api.utils.R;
import com.wangbo.website.profile.entity.ProfileInfo;
import com.wangbo.website.profile.service.IProfileInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司简介接口
 *
 * @author xingyu
 * @date 2019/1/28
 */
@Api("公司简介接口")
@RestController
@RequestMapping("/api/profile")
public class ProfileInfoApiController {
    @Autowired
    private IProfileInfoService profileInfoService;

    @ApiOperation(value="获取公司信息",notes="获取公司信息")
    @GetMapping(value = "/info")
    public R getInfo(){
        ProfileInfo info  = profileInfoService.selectProfileInfoById(1);
        if(null != info){
            return R.ok("200","获取成功",info);
        }else{
            return R.error("500","信息不存在");
        }
    }
}

