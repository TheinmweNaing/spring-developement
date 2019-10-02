package com.team.fine.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data
public class MemberFineDTO {

	private static final DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM dd, yyyy");
	private String date;
	private String name;
	private int fine;

	public MemberFineDTO() {
		super();
	}

	public MemberFineDTO(LocalDate date, String name, int fine) {
		super();
		this.date = date.format(df);
		this.name = name;
		this.fine = fine;
	}
}
