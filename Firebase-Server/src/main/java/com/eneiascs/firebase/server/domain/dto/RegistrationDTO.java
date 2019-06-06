package com.eneiascs.firebase.server.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.eneiascs.firebase.server.domain.Registration;

public class RegistrationDTO {
	private String token;
	private List<String> topics;
	
	
	public RegistrationDTO() {
		super();
	}
	public RegistrationDTO(Registration registration) {
		super();
		if(registration != null) {
			this.setToken(registration.getToken());
			this.setTopics(registration.getTopics().stream().map(topic -> topic.getDescription()).collect(Collectors.toList()));
		}
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<String> getTopics() {
		return topics;
	}
	public void setTopics(List<String> topics) {
		this.topics = topics;
	}
	
}
