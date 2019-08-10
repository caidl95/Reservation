package com.example.demo.common.dao;


import com.example.demo.common.entity.BaseEntity;

/**
 * Mapper基类
 */
public interface BaseMapper<T extends BaseEntity> {

    /**
     * 根据entityId删除记录
     *
     */
    Integer deleteByPrimaryKey(Integer id);

    /**
     * 新增entity
     *
     */
    Integer insert(T entity);

    /**
     * 动态新增entity
     *
     */
    Integer insertSelective(T entity);

    /**
     * 根据entityId查询
     *
     */
    T selectByPrimaryKey(Integer id);

    /**
     * 动态更新entity
     *
     */
    Integer updateByPrimaryKeySelective(T entity);

    /**
     * 更新entity
     *
     */
    Integer updateByPrimaryKey(T entity);
}
