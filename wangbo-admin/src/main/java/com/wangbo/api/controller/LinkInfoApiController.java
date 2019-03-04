package com.wangbo.api.controller;

import com.wangbo.api.utils.R;
import com.wangbo.website.link.entity.LinkInfo;
import com.wangbo.website.link.service.ILinkInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公司信息Api
 *
 * @author xingyu
 * @date 2019/1/14
 */
@Api("公司信息接口")
@RestController
@RequestMapping("/api/link")
public class LinkInfoApiController {

    @Autowired
    private ILinkInfoService linkInfoService;

    @ApiOperation(value="获取公司信息",notes="获取公司信息")
    @GetMapping(value = "/info")
    public R get() throws NullPointerException{
        LinkInfo linkInfo =  linkInfoService.selectLinkInfoById(1);
        if(null != linkInfo){
            return R.ok("200","获取成功",linkInfo);
        }else {
            return R.error("500","信息不存在");
        }
    }
}

