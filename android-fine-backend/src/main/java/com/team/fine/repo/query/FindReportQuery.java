package com.team.fine.repo.query;

import java.util.Map;

public class FindReportQuery implements SimpleQuery {

	@Override
	public String query() {
		return "SELECT new com.team.fine.dto.ReportDTO(m.name,SUM(f.fine)) FROM Member m LEFT JOIN Fine f ON m.id = f.member.id "
				+ "GROUP BY m.name ";
	}

	@Override
	public Map<String, Object> params() {
		return null;
	}
	
	

}
