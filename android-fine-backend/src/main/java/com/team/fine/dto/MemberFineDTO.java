package com.team.fine.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.team.fine.LocalDateToTimestampSerializer;

import lombok.Data;

@Data
public class MemberFineDTO {

	@JsonSerialize(using = LocalDateToTimestampSerializer.class)
	private LocalDate date;
	private String name;
	private int fine;
	private long fineId;
	private int memberId;

	public MemberFineDTO() {
		super();
	}

	public MemberFineDTO(LocalDate date, String name, int fine, long fineId, int memberId) {
		super();
		this.date = date;
		this.name = name;
		this.fine = fine;
		this.fineId = fineId;
		this.memberId = memberId;
	}
}
