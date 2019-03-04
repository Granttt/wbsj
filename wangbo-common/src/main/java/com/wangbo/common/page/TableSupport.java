package com.wangbo.common.page;

import com.wangbo.common.constant.Constants;
import com.wangbo.common.page.PageEntity;
import com.wangbo.common.utils.ServletUtils;

/**
 * 表格数据处理
 *
 * @author X
 */
public class TableSupport {
    /**
     * 封装分页对象
     */
    private static PageEntity getPageEntity() {
        PageEntity pageEntity = new PageEntity();
        pageEntity.setPageNum(ServletUtils.getParameterToInt(Constants.PAGE_NUM));
        pageEntity.setPageSize(ServletUtils.getParameterToInt(Constants.PAGE_SIZE));
        pageEntity.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
        pageEntity.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
        return pageEntity;
    }

    public static PageEntity buildPageRequest() {
        return getPageEntity();
    }
}
