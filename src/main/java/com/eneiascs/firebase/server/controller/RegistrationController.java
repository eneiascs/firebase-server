package com.eneiascs.firebase.server.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eneiascs.firebase.server.domain.dto.RegistrationDTO;
import com.eneiascs.firebase.server.domain.dto.TopicDTO;
import com.eneiascs.firebase.server.service.RegistrationService;
import com.eneiascs.firebase.server.service.TopicService;
import com.google.firebase.messaging.FirebaseMessagingException;

@RestController
public class RegistrationController {
	
	@Resource
	private TopicService topicService;
	
	@Resource
	private RegistrationService registrationService;
	
	@PostMapping("/register")
	public  RegistrationDTO onRegistration(@RequestBody RegistrationDTO registration) {
		return registrationService.register(registration);
	}
	@GetMapping("/topics")
	public List<TopicDTO> topics() {
		
		return topicService.findAll();
	}
}
