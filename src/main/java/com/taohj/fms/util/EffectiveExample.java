package com.taohj.fms.util;

import java.util.Date;

import tk.mybatis.mapper.entity.Example;

public abstract class EffectiveExample extends Example {

	public static final String PROPERTY_STATE = "state";
	public static final String PROPERTY_EXPIRE_DATE = "expireDate";
	public static final String PROPERTY_EFFECTIVE_DATE = "effectiveDate";

	public EffectiveExample(Class<?> entityClass) {
		super(entityClass);
		Criteria criteria = this.createCriteria();
		criteria.andEqualTo(PROPERTY_STATE, State.U.name());
		Date cur = new Date();
		criteria.andGreaterThanOrEqualTo(PROPERTY_EXPIRE_DATE, cur);
		criteria.andLessThanOrEqualTo(PROPERTY_EFFECTIVE_DATE, cur);
		fillCriteria(criteria);
	}

	protected abstract void fillCriteria(Criteria criteria);

}