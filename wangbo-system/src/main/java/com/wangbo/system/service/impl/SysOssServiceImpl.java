package com.wangbo.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wangbo.system.mapper.SysOssMapper;
import com.wangbo.system.entity.SysOss;
import com.wangbo.system.service.ISysOssService;
import com.wangbo.common.support.Convert;

/**
 * 文件上传 服务层实现
 * 
 * @author xingyu
 * @date 2019-01-10
 */
@Service
public class SysOssServiceImpl implements ISysOssService 
{
	@Autowired
	private SysOssMapper sysOssMapper;

	/**
     * 查询文件上传信息
     * 
     * @param fileId 文件上传ID
     * @return 文件上传信息
     */
    @Override
	public SysOss selectSysOssById(Long fileId)
	{
	    return sysOssMapper.selectSysOssById(fileId);
	}
	
	/**
     * 查询文件上传列表
     * 
     * @param sysOss 文件上传信息
     * @return 文件上传集合
     */
	@Override
	public List<SysOss> selectSysOssList(SysOss sysOss)
	{
	    return sysOssMapper.selectSysOssList(sysOss);
	}
	
    /**
     * 新增文件上传
     * 
     * @param sysOss 文件上传信息
     * @return 结果
     */
	@Override
	public int insertSysOss(SysOss sysOss)
	{
	    return sysOssMapper.insertSysOss(sysOss);
	}
	
	/**
     * 修改文件上传
     * 
     * @param sysOss 文件上传信息
     * @return 结果
     */
	@Override
	public int updateSysOss(SysOss sysOss)
	{
	    return sysOssMapper.updateSysOss(sysOss);
	}

	/**
     * 删除文件上传对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSysOssByIds(String ids)
	{
		return sysOssMapper.deleteSysOssByIds(Convert.toStrArray(ids));
	}
	
}
