package com.wangbo.api.entity;

import com.wangbo.website.cms.entity.CmsArticle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 文章接口实体
 *
 * @author xingyu
 * @date 2019/1/11
 */
@ApiModel(value="文章对象",description="文章Article")
public class Article {
    /** 总条数 */
    @ApiModelProperty(value="总条数",example ="104")
    private Integer count ;
    /** 总页数 */
    @ApiModelProperty(value="总页数",example ="10")
    private Integer totalpages;
    /** 当前页 */
    @ApiModelProperty(value="当前页",example ="1")
    private Integer pageNo;
    /** LIST */
    @ApiModelProperty(value="LIST",example ="LIST")
    private List<CmsArticle> articleList;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(Integer totalpages) {
        this.totalpages = totalpages;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public List<CmsArticle> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<CmsArticle> articleList) {
        this.articleList = articleList;
    }
}

