package com.eneiascs.firebase.server.domain.dto;

import java.util.List;

public class NotificationDTO {
	private String message;
	private List<String> topics;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<String> getTopics() {
		return topics;
	}
	public void setTopics(List<String> topics) {
		this.topics = topics;
	}
	
	
}
