package com.eneiascs.firebase.server.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eneiascs.firebase.server.domain.Registration;
import com.eneiascs.firebase.server.domain.Topic;
import com.eneiascs.firebase.server.domain.dto.RegistrationDTO;
import com.eneiascs.firebase.server.repository.RegistrationRepository;
import com.eneiascs.firebase.server.repository.TopicRepository;
import com.eneiascs.firebase.server.service.RegistrationService;
@Service
public class RegistrationServiceImpl implements RegistrationService{
	@Resource
	private RegistrationRepository repository;
	
	@Resource
	private TopicRepository topicRepository;
	
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
		Registration registration = new Registration();
		registration.setToken(dto.getToken());
		List<Topic> topicsDB = dto.getTopics().stream().map(topic -> topicRepository.findByDescription(topic).stream().findFirst().orElse(null)).filter(topic -> topic !=null).collect(Collectors.toList());
		registration.setTopics(topicsDB);
		registration = save(registration);
		return new RegistrationDTO(registration);
	}

}
