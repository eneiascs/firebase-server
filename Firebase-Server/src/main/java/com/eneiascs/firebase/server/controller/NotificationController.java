package com.eneiascs.firebase.server.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eneiascs.firebase.server.domain.dto.NotificationDTO;
import com.eneiascs.firebase.server.service.NotificationService;

@RestController
public class NotificationController {
	@Resource
	private NotificationService notificationService;
	@PostMapping("/messaging/send")
	public String send(@RequestBody NotificationDTO notificationDTO) {
		 
		return notificationService.sendMessage(notificationDTO);
	}
}
