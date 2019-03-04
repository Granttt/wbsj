package com.wangbo.api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 文章详情api
 *
 * @author xingyu
 * @date 2019/1/11
 */
@ApiModel(value = "文章详情",description="文章详情ArticleData")
public class ArticleData {
    /**
     * 标题
     */
    @ApiModelProperty(value="标题",example ="标题标题")
    private String title;

    /**
     * 文章内容
     */
    @ApiModelProperty(value="文章内容",example ="文章内容文章内容文章内容")
    private String content;

    /**
     * 文章来源
     */
    @ApiModelProperty(value="文章来源",example ="文章来源文章来源")
    private String copyfrom;

    /**
     * 作者
     */
    @ApiModelProperty(value="作者",example ="作者作者")
    private String author;
    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间",example ="创建时间")
    private String createTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCopyfrom() {
        return copyfrom;
    }

    public void setCopyfrom(String copyfrom) {
        this.copyfrom = copyfrom;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}

