package com.team.sp.repo;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class CustomRepoImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomRepo<T, ID> {

	private EntityManager em;

	public CustomRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}

	@Override
	public List<T> find(String where, Map<String, Object> params) {
		String query = "SELECT t FROM %s t WHERE 1 = 1 " + (where != null ? where : "");

		TypedQuery<T> typedQuery = em.createQuery(String.format(query, getDomainClass().getSimpleName()),
				getDomainClass());
		if (params != null) {
			params.forEach(typedQuery::setParameter);
		}
		return typedQuery.getResultList();
	}

}
