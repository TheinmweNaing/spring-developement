package com.team.fine.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.team.fine.LocalDateDeserializer;
import com.team.fine.LocalDateToTimestampSerializer;
import com.team.fine.entity.Fine;

import lombok.Data;

@Data
public class FineDTO {

	private long id;
	private int fine;
	@JsonSerialize(using = LocalDateToTimestampSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate issueDate;
	private int memberId;

	public FineDTO() {
		super();
	}

	public FineDTO(Fine fine) {
		this.id = fine.getId();
		this.fine = fine.getFine();
		this.issueDate = fine.getIssueDate();
		this.memberId = fine.getMember().getId();
	}

}
