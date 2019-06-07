package com.eneiascs.firebase.server.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	
	
	public Topic() {
		super();
	}
	public Topic(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
