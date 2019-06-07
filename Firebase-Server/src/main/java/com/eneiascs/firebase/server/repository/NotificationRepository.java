package com.eneiascs.firebase.server.repository;

import org.springframework.data.repository.CrudRepository;

import com.eneiascs.firebase.server.domain.Notification;

public interface NotificationRepository extends CrudRepository<Notification, Long> {

	

}
