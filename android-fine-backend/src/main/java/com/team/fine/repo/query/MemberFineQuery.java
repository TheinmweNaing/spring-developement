package com.team.fine.repo.query;

import java.util.Map;

public class MemberFineQuery implements SimpleQuery, Pageable {

	private int offset;
	private int limit;

	@Override
	public String query() {
		return "SELECT new com.team.fine.dto.MemberFineDTO(f.issueDate,m.name,f.fine) FROM Fine f LEFT JOIN Member m ON m.id = f.member.id "
				+ "ORDER BY f.issueDate DESC ";
	}

	@Override
	public Map<String, Object> params() {
		return null;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public int offset() {
		return offset;
	}

	@Override
	public int limit() {
		return limit;
	}
}
