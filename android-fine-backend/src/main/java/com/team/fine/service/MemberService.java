package com.team.fine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.fine.dto.MemberSummaryDTO;
import com.team.fine.entity.Member;
import com.team.fine.repo.MemberRepo;
import com.team.fine.repo.query.MemberSummaryQuery;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepo repo;

	public void save(Member member) {
		repo.save(member);
	}

	public Member findById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Member> findAll() {
		return repo.findAll();
	}

	public List<MemberSummaryDTO> findAllMemberSummary() {
		return repo.findVO(new MemberSummaryQuery(), MemberSummaryDTO.class);
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
}
