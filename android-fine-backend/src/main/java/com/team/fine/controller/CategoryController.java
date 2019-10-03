package com.team.fine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team.fine.entity.Category;
import com.team.fine.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@PostMapping
	public void save(@RequestBody Category c) {
		service.save(c);
	}

	@GetMapping("{id}")
	public Category findById(@PathVariable int id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Category> findAll() {
		return service.findAll();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}
}
