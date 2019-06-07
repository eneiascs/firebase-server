package com.eneiascs.firebase.server.service;

import java.util.List;
import java.util.Optional;

import com.eneiascs.firebase.server.domain.Topic;
import com.eneiascs.firebase.server.domain.dto.TopicDTO;

public interface TopicService {
	public Iterable<Topic> save(List<Topic> topics);
	public Topic save(Topic topic);
	public void delete(Topic topic);
	public Optional<Topic> findById(Long id);
	public List<TopicDTO> findAll();
	public List<Topic> getTopicsDB(List<String> topics);
	
	
	
}
