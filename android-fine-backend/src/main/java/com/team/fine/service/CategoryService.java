package com.team.fine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.fine.entity.Category;
import com.team.fine.repo.CategoryRepo;

@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepo repo;

	public void save(Category category) {
		repo.save(category);
	}
	
	public Category findById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Category> findAll() {
		return repo.findAll();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
	
}
