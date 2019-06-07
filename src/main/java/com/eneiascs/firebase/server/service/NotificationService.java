package com.eneiascs.firebase.server.service;

import com.eneiascs.firebase.server.domain.dto.NotificationDTO;
import com.google.firebase.messaging.FirebaseMessagingException;

public interface NotificationService {
	public String sendMessage(NotificationDTO notificationDTO) throws FirebaseMessagingException;
}
