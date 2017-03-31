package com.taohj.fms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.taohj.fms.service.IService;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

public abstract class BaseService<T> implements IService<T> {

	@Autowired
	protected Mapper<T> mapper;

	public Mapper<T> getMapper() {
		return mapper;
	}

	@Override
	public T selectByKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}

	public int save(T entity) {
		return mapper.insert(entity);
	}

	public int delete(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	public int updateAll(T entity) {
		return mapper.updateByPrimaryKey(entity);
	}

	public int updateNotNull(T entity) {
		return mapper.updateByPrimaryKeySelective(entity);
	}

	public List<T> selectByExample(Object example) {
		return mapper.selectByExample(example);
	}

	// TODO 其他...

	protected T selectOne(Example example) {
		List<T> vals = selectByExample(example);
		if (CollectionUtils.isEmpty(vals)) {
			return null;
		}
		Assert.state(vals.size() == 1);
		return vals.get(0);
	}
}
