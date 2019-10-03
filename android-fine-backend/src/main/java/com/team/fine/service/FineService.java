package com.team.fine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.team.fine.dto.FineDTO;
import com.team.fine.dto.MemberFineDTO;
import com.team.fine.entity.Fine;
import com.team.fine.repo.FineRepo;
import com.team.fine.repo.MemberRepo;
import com.team.fine.repo.query.MemberFineQuery;

@Service
@Transactional
public class FineService {

	@Autowired
	private FineRepo repo;

	@Autowired
	private MemberRepo memberRepo;

	public void save(Fine fine) {
		repo.save(fine);
	}

	public void save(FineDTO dto) {
		Fine fine = new Fine();
		fine.setId(dto.getId());
		fine.setFine(dto.getFine());
		fine.setIssueDate(dto.getIssueDate());
		fine.setMember(memberRepo.findById(dto.getMemberId()).orElseThrow(() -> new UnsupportedOperationException()));
		repo.save(fine);
	}

	public FineDTO findById(long id) {
		return repo.findById(id).map(FineDTO::new).orElse(null);
	}

	public List<MemberFineDTO> find(int offset, int limit) {
		MemberFineQuery query = new MemberFineQuery();
		query.setOffset(offset);
		query.setLimit(limit);
		return repo.findVO(query, MemberFineDTO.class);
	}

	public void delete(long id) {
		repo.deleteById(id);
	}
}
