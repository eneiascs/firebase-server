package com.eneiascs.firebase.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eneiascs.firebase.server.domain.Notification;
import com.eneiascs.firebase.server.domain.Topic;
import com.eneiascs.firebase.server.domain.dto.NotificationDTO;
import com.eneiascs.firebase.server.repository.NotificationRepository;
import com.eneiascs.firebase.server.service.FirebaseService;
import com.eneiascs.firebase.server.service.NotificationService;
import com.eneiascs.firebase.server.service.TopicService;
import com.google.firebase.messaging.FirebaseMessagingException;

@Service
public class NotificationServiceImpl implements NotificationService {
	@Resource
	private NotificationRepository notificationRepository;
	
	@Resource
	private TopicService topicService;
	
	@Resource
	private FirebaseService firebaseService;
	
	@Override
	public String sendMessage(NotificationDTO notificationDTO) throws FirebaseMessagingException {
		String response = firebaseService.sendMessage(notificationDTO);
		Notification notification = new Notification();
		notification.setMessage(notificationDTO.getMessage());
		notification.setSender("admin");
		List<Topic> topicsDB = topicService.getTopicsDB(notificationDTO.getTopics());
		notification.setTopics(topicsDB);
		notificationRepository.save(notification);
		return response;
		
	}

}
