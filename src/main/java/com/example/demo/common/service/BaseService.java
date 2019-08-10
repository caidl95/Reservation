package com.example.demo.common.service;


import com.example.demo.common.entity.BaseEntity;
import com.example.demo.common.serverResponse.ServerResponse;

/**
 * Service公共接口
 */
public interface BaseService<T extends BaseEntity> {

	/**
	 * 新增entity
	 *
	 */
	ServerResponse insert(T entity);

	/**
	 * 根据entityId删除记录
	 *
	 */
	ServerResponse deleteByPrimaryKey(Integer id);

	/**
	 * 更新entity
	 *
	 */
	ServerResponse updateByPrimaryKey(T entity);

	/**
	 * 根据entityId查询
	 *
	 */
	ServerResponse<T> selectByPrimaryKey(Integer id);

}
