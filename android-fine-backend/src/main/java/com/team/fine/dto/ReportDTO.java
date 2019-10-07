package com.team.fine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportDTO {

	private String name;
	private long amount;

	public ReportDTO(String name, long amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

}
