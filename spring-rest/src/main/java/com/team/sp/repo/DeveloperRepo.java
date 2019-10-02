package com.team.sp.repo;

import java.util.List;

import com.team.sp.entities.Developer;

public interface DeveloperRepo extends CustomRepo<Developer, Integer> {

	List<Developer> findBySpecialize(String specialize);

	List<Developer> findByNameLike(String name);

	List<Developer> findByNameAndSpecialize(String name, String specialize);

}
