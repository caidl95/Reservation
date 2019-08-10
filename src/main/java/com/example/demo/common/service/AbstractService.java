package com.example.demo.common.service;

import com.example.demo.common.dao.BaseMapper;
import com.example.demo.common.entity.BaseEntity;
import com.example.demo.common.serverResponse.ServerResponse;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Service抽象类
 */
public abstract class AbstractService<T extends BaseEntity, D extends BaseMapper<T>> implements BaseService<T> {

	/**
	 * 业务日志记录
	 */
	protected static Logger log = Logger.getLogger(AbstractService.class);

	/**
	 * 自动注入主表mapper
	 */
	@Autowired
	protected D mapper;

	/**
	 * 新增entity
	 *
	 */
	public ServerResponse insert(T entity){
		return ServerResponse.createByErrorMessage("功能为开启，请联系管理员");
	}


	/**
	 * 根据entityId删除记录
	 *
	 */
	public ServerResponse deleteByPrimaryKey(Integer id) {
		return ServerResponse.createByErrorMessage("功能为开启，请联系管理员");
	}

	/**
	 * 更新entity
	 *
	 */
	public ServerResponse updateByPrimaryKey(T entity) {
		return ServerResponse.createByErrorMessage("功能为开启，请联系管理员");
	}

	/**
	 * 根据entityId查询
	 *
	 */
	public ServerResponse<T> selectByPrimaryKey(Integer id) {
		return ServerResponse.createByErrorMessage("功能为开启，请联系管理员");
	}



}
