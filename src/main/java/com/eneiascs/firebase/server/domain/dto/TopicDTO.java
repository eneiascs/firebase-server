package com.eneiascs.firebase.server.domain.dto;

import com.eneiascs.firebase.server.domain.Topic;

public class TopicDTO {
	
	private String name;
	private String description;
	
	
	public TopicDTO() {
		super();
	}
	public TopicDTO(Topic topic) {
		super();
		if(topic != null) {
			this.name = topic.getName();
			this.description = topic.getDescription();
		}
		
	}
	public TopicDTO(String description) {
		super();
		this.description = description;
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
