package com.team.sp.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomRepo<T, ID> extends JpaRepository<T, ID> {

	List<T> find(String where, Map<String, Object> params);
}
