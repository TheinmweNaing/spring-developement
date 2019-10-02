package com.team.sp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.sp.entities.Developer;
import com.team.sp.repo.DeveloperRepo;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

	@Autowired
	private DeveloperRepo repo;

	@PostMapping
	public Developer create(@RequestBody Developer developer) {
		return repo.save(developer);
	}

	@PutMapping
	public Developer update(@RequestBody Developer developer) {
		return repo.save(developer);
	}

	@GetMapping
	public List<Developer> findAll(@RequestParam(required = false) String name,
			@RequestParam(required = false) String specialize) {

		Map<String, Object> params = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		if (name != null) {
			sb.append("and t.name like :name ");
			params.put("name", name.concat("%"));
		}

		if (specialize != null) {
			sb.append("and t.specialize = :specialize ");
			params.put("specialize", specialize);
		}
		return repo.find(sb.toString(), params);
	}

	@GetMapping("{id}")
	public Developer findById(@PathVariable int id) {
		return repo.findById(id).orElse(null);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		repo.deleteById(id);
	}
}
