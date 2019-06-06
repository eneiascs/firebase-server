package com.eneiascs.firebase.server.service.impl;

import org.springframework.stereotype.Service;

import com.eneiascs.firebase.server.domain.dto.NotificationDTO;
import com.eneiascs.firebase.server.service.NotificationService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class NotificationServiceImpl implements NotificationService {

	@Override
	public String sendMessage(NotificationDTO notificationDTO) {
		String registrationToken = "cf8tfSWxoc0:APA91bFetxY-gRsw0HDVyQtMo_pjeDw2tzWQetyYFV9kN2JhOz01qBUeNcNT4fhmS_N6DJjGvzFBvVd1mu8v2PA17JnGeD52MgjvQbGGSbKDbejxRFcGee3g5HJfKZvxlfNt0i69UTCn";
		Message firebaseMessage = Message.builder()
				.setNotification(new Notification("Band zap", notificationDTO.getMessage()))
				.putData("score", "850")
				.putData("time", "2:45")
				.setToken(registrationToken)
				.build();
		System.out.println("Construiu a msg.");

		String response = null;
		try {
			System.out.println("vai tentar enviar a mensagem.");
			response = FirebaseMessaging.getInstance().send(firebaseMessage);
		} catch (FirebaseMessagingException e) {
			
			e.printStackTrace();
		}
		System.out.println("Successfully sent message: " + response);

		return "Successfully sent message: " + response;
	}

}
