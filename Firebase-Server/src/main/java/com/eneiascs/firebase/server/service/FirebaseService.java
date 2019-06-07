package com.eneiascs.firebase.server.service;

import com.eneiascs.firebase.server.domain.dto.NotificationDTO;
import com.google.firebase.messaging.FirebaseMessagingException;

public interface FirebaseService {

	String sendMessage(NotificationDTO notificationDTO) throws FirebaseMessagingException;

	void subscribe(String token, String topic)  throws FirebaseMessagingException;
	void unsubscribe(String token, String topic)  throws FirebaseMessagingException;


}
