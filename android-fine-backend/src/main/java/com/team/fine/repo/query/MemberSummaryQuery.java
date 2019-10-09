package com.team.fine.repo.query;

import java.util.Map;

public class MemberSummaryQuery implements SimpleQuery {

	@Override
	public String query() {
		return "SELECT new com.team.fine.dto.MemberSummaryDTO(m.id,m.name,SUM(f.fine), m.photo) FROM Member m LEFT JOIN Fine f ON m.id = f.member.id "
				+ "GROUP BY m.id,m.name ";
	}

	@Override
	public Map<String, Object> params() {
		return null;
	}

}
