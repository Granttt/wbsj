package com.wangbo.common.exception.file;

import com.wangbo.common.exception.base.BaseException;

/**
 * 文件信息异常类
 *
 * @author xingyu
 * @date 2019/1/31
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}

