package com.eneiascs.firebase.server.service.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eneiascs.firebase.server.domain.Registration;
import com.eneiascs.firebase.server.domain.Topic;
import com.eneiascs.firebase.server.domain.dto.RegistrationDTO;
import com.eneiascs.firebase.server.repository.RegistrationRepository;
import com.eneiascs.firebase.server.service.FirebaseService;
import com.eneiascs.firebase.server.service.RegistrationService;
import com.eneiascs.firebase.server.service.TopicService;
import com.google.firebase.messaging.FirebaseMessagingException;
@Service
public class RegistrationServiceImpl implements RegistrationService{
	@Resource
	private RegistrationRepository repository;
	
	@Resource
	private TopicService topicService;
	
	@Resource
	private FirebaseService firebaseService;
	
	
	@Override
	public Registration save(Registration registration) {
		
		return repository.save(registration);
	}

	@Override
	public void delete(Registration registration) {
		
		repository.delete(registration);
		return;
	}

	@Override
	public Optional<Registration> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Iterable<Registration> findAll() {
		
		return repository.findAll();
	}

	@Override
	public RegistrationDTO register(RegistrationDTO dto) {
		
		Optional<Registration> currentRegistration = findCurrentRegistration(dto.getToken());
		
		if (currentRegistration.isPresent()) {
			
			currentRegistration.get().getTopics().stream().forEach(topic -> {
				try {
					firebaseService.unsubscribe(currentRegistration.get().getToken(), topic.getName());
				} catch (FirebaseMessagingException e) {
					
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			});
		}
		
		dto.getTopics().stream().forEach(topic -> {
			try {
				firebaseService.subscribe(dto.getToken(), topic);
			} catch (FirebaseMessagingException e) {
				
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		});
		
		Registration registration = new Registration();
		registration.setToken(dto.getToken());
		List<Topic> topicsDB = topicService.getTopicsDB(dto.getTopics());
		registration.setTopics(topicsDB);
		registration = save(registration);
		return new RegistrationDTO(registration);
	}
	@Override
	public Optional<Registration> findCurrentRegistration(String token) {
		
		return repository.findCurrentRegistration(token);
	}

}
