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

import com.team.fine.dto.MemberSummaryDTO;
import com.team.fine.entity.Member;
import com.team.fine.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService service;

	@PostMapping
	public void save(@RequestBody Member m) {
		service.save(m);
	}

	@GetMapping("{id}")
	public Member findById(@PathVariable int id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Member> findAll() {
		return service.findAll();
	}

	@GetMapping("summary")
	public List<MemberSummaryDTO> find() {
		return service.findAllMemberSummary();
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

}
