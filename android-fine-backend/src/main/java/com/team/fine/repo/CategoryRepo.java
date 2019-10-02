package com.team.fine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team.fine.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
