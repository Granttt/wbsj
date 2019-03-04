package com.wangbo.api.controller;

import com.wangbo.api.entity.Article;
import com.wangbo.api.entity.ArticleData;
import com.wangbo.api.utils.R;
import com.wangbo.common.utils.JodaDateUtils;
import com.wangbo.website.cms.entity.CmsArticle;
import com.wangbo.website.cms.entity.CmsArticleData;
import com.wangbo.website.cms.service.ICmsArticleDataService;
import com.wangbo.website.cms.service.ICmsArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : xingyu4j
 * @version : 1.0.0
 * @Date : 2019/1/11 13:50
 */
@Api("新闻接口")
@RestController
@RequestMapping("/api/article")
public class ArticleApiController {
    /**日志对象**/
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    /** 每页显示记录条数 **/
    private static final int PAGE_SIZE = 10;

    @Autowired
    private ICmsArticleService cmsArticleService;

    @Autowired
    private ICmsArticleDataService cmsArticleDataService;

    @ApiOperation(value="获取新闻列表",notes="自带分页新闻列表，传入页数获取当前页列表")
    @ApiImplicitParam(name = "page_no", value = "页数", dataType = "Integer")
    @GetMapping(value = "/list")
    public R getList(@RequestParam Integer page_no) throws NullPointerException{
        if(null == page_no && 0 == page_no){
            page_no = 1;
        }
        //总条数
        int count= cmsArticleService.selectCmsArticleCount();
        //起始条数
        int begin =PAGE_SIZE *(page_no -1);
        //总页数
        int totalpages= count/PAGE_SIZE +1;

        List<CmsArticle> articleList = cmsArticleService.selectCmsArticlePage(begin,PAGE_SIZE);

        Article article = new Article();
        article.setPageNo(page_no);
        article.setCount(count);
        article.setTotalpages(totalpages);
        article.setArticleList(articleList);
        return R.ok("200","请求成功",article);
    }
    @ApiOperation(value="获取新闻详情",notes="根据新闻ID获取详情信息")
    @ApiImplicitParam(name = "id", value = "新闻ID", dataType = "String")
    @GetMapping(value = "getData")
    public R getData(@RequestParam String id){
        CmsArticle cmsArticle = cmsArticleService.selectCmsArticleById(id);
        CmsArticleData cmsArticleData = cmsArticleDataService.selectCmsArticleDataById(id);
        ArticleData articleData = new ArticleData();
        if(null != cmsArticle){
            articleData.setTitle(cmsArticle.getTitle());
            articleData.setAuthor(cmsArticle.getAuthor());
            articleData.setContent(cmsArticleData.getContent());
            articleData.setCopyfrom(cmsArticleData.getCopyfrom());
            articleData.setCreateTime(JodaDateUtils.format(cmsArticleData.getCreateTime(),"yyyy-MM-dd"));
            return R.ok("200","请求成功",articleData);
        }else{
            return R.error("数据不存在");
        }


    }

}
