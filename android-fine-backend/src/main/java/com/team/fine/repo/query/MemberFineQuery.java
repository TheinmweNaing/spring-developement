package com.team.fine.repo.query;

import java.util.Map;

public class MemberFineQuery implements SimpleQuery {

	@Override
	public String query() {
		return "SELECT new com.team.fine.dto.MemberFineDTO(f.issueDate,m.name,f.fine, f.id, m.id) FROM Fine f LEFT JOIN Member m ON m.id = f.member.id "
				+ "ORDER BY f.issueDate DESC ";
	}

	@Override
	public Map<String, Object> params() {
		return null;
	}
}
