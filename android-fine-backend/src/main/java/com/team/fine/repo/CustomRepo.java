package com.team.fine.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.team.fine.repo.query.SimpleQuery;

@NoRepositoryBean
public interface CustomRepo<T, ID> extends JpaRepository<T, ID> {

	List<T> find(SimpleQuery query);

	<V> List<V> findVO(SimpleQuery query, Class<V> clazz);
}
