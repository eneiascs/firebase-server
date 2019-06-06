package com.eneiascs.firebase.server.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	
	
	public Topic() {
		super();
	}
	public Topic(String description) {
		super();
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
	
}
