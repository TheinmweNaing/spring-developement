package com.team.fine.dto;

import lombok.Data;

@Data
public class MemberSummaryDTO {

	private int id;
	private String name;
	private long fine;
	private String photo;

	public MemberSummaryDTO() {
		super();
	}

	public MemberSummaryDTO(int id, String name, Long fine, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.fine = fine != null ? fine : 0;
		this.photo = photo;
	}

}
