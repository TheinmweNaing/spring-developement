package com.team.fine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.fine.dto.FineDTO;
import com.team.fine.dto.MemberFineDTO;
import com.team.fine.service.FineService;

@RestController
@RequestMapping("/fine")
public class FineController {

	@Autowired
	private FineService service;

	@PostMapping
	public void save(@RequestBody FineDTO fine) {
		service.save(fine);
	}

	@GetMapping("{id}")
	public FineDTO findById(@PathVariable long id) {
		return service.findById(id);
	}

	@GetMapping
	public List<MemberFineDTO> find(@RequestParam int offset, @RequestParam int limit) {
		return service.find(offset, limit);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		service.delete(id);
	}

}
