package com.team.fine.controller;

import java.util.List;
import java.util.Optional;

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
import com.team.fine.dto.ReportDTO;
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
	public List<MemberFineDTO> find(
			@RequestParam(required = false) Optional<Integer> offset, 
			@RequestParam(required = false) Optional<Integer> limit) {
		return offset.isPresent() && limit.isPresent() ? service.find(offset.get(), limit.get()) : service.findAll();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable long id) {
		service.delete(id);
	}

	@GetMapping("report")
	public List<ReportDTO> findReport() {
		return service.findReport();
	}

}
