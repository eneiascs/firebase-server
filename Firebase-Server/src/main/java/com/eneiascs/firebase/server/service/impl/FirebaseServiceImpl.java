package com.eneiascs.firebase.server.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.eneiascs.firebase.server.domain.dto.NotificationDTO;
import com.eneiascs.firebase.server.domain.dto.RegistrationDTO;
import com.eneiascs.firebase.server.service.FirebaseService;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.google.firebase.messaging.TopicManagementResponse;

@Service
public class FirebaseServiceImpl implements FirebaseService {

	@Override
	public String sendMessage(NotificationDTO notificationDTO) throws FirebaseMessagingException {
		
		List<Message> messages = notificationDTO.getTopics().stream().map(topic -> Message.builder()
					.setNotification(new Notification(topic, notificationDTO.getMessage()))
					.setTopic(topic)
					.build()
		).collect(Collectors.toList());
		
		BatchResponse response = FirebaseMessaging.getInstance().sendAll(messages);
		
		System.out.println(response.getSuccessCount() + " messages were sent successfully");
		

		return String.format("Success: %s. Failure: %s", response.getSuccessCount(), response.getFailureCount());
	}

	@Override
	public void subscribe(String token, String topic) throws FirebaseMessagingException {
		List<String> registrationTokens = Arrays.asList(token);
			TopicManagementResponse response = FirebaseMessaging.getInstance().subscribeToTopic(
			    registrationTokens, topic);
			System.out.println(response.getSuccessCount() + " tokens were subscribed successfully");
			System.out.println(String.format("token: %s\ntopic: %s", token, topic));

	}

	@Override
	public void unsubscribe(String token, String topic) throws FirebaseMessagingException {
		List<String> registrationTokens = Arrays.asList(token);
		TopicManagementResponse response = FirebaseMessaging.getInstance().unsubscribeFromTopic(
			    registrationTokens, topic);
			
			System.out.println(response.getSuccessCount() + " tokens were unsubscribed successfully");
			System.out.println(String.format("token: %s\ntopic: %s", token, topic));

	}

	
}
