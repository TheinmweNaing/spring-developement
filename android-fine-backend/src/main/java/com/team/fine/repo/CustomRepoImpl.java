package com.team.fine.repo;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.team.fine.repo.query.Pageable;
import com.team.fine.repo.query.SimpleQuery;

public class CustomRepoImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomRepo<T, ID> {

	private EntityManager em;

	public CustomRepoImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.em = entityManager;
	}

	@Override
	public List<T> find(SimpleQuery query) {
		return find(query, null);
	}

	@Override
	public <V> List<V> findVO(SimpleQuery query, Class<V> clazz) {
		return findVO(query, clazz, null);
	}

	@Override
	public List<T> find(SimpleQuery query, Pageable pageable) {
		TypedQuery<T> typedQuery = em.createQuery(query.query(), getDomainClass());
		Map<String, Object> params = query.params();
		if (params != null) {
			params.forEach(typedQuery::setParameter);
		}
		if (pageable != null) {
			typedQuery.setFirstResult(pageable.offset());
			typedQuery.setMaxResults(pageable.limit());
		}
		return typedQuery.getResultList();
	}

	@Override
	public <V> List<V> findVO(SimpleQuery query, Class<V> clazz, Pageable pageable) {
		TypedQuery<V> typedQuery = em.createQuery(query.query(), clazz);
		Map<String, Object> params = query.params();
		if (params != null) {
			params.forEach(typedQuery::setParameter);
		}
		if (pageable != null) {
			typedQuery.setFirstResult(pageable.offset());
			typedQuery.setMaxResults(pageable.limit());
		}
		return typedQuery.getResultList();
	}

}
