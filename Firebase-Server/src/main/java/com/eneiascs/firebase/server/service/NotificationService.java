package com.eneiascs.firebase.server.service;

import com.eneiascs.firebase.server.domain.dto.NotificationDTO;

public interface NotificationService {
	public String sendMessage(NotificationDTO notificationDTO);
}
