package com.team.sp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Developer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String specialize;
	
	public Developer() {
		super();
	}

	public Developer(String name, String specialize) {
		super();
		this.name = name;
		this.specialize = specialize;
	}

}
