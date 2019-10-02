package com.team.fine.repo.query;

public abstract class AbstractQuery<T> implements SimpleQuery {

	protected String baseQuery;

	public AbstractQuery(Class<T> clazz) {
		this.baseQuery = String.format("SELECT t FROM %s t WHERE 1=1 ", clazz.getSimpleName());
	}
}
