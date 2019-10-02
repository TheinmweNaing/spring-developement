package com.team.fine.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.team.fine.LocalDateDeserializer;

import lombok.Data;

@Data
public class FineDTO {

	private long id;
	private int fine;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate issueDate;
	private int memberId;
}
