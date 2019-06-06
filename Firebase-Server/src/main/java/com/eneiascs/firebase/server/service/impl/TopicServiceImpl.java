package com.eneiascs.firebase.server.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.eneiascs.firebase.server.domain.Topic;
import com.eneiascs.firebase.server.repository.TopicRepository;
import com.eneiascs.firebase.server.service.TopicService;
@Service
public class TopicServiceImpl implements TopicService{
	@Resource
	private TopicRepository topicRepository;
	@Override
	public Iterable<Topic> save(List<Topic> topics) {
		
		return topicRepository.saveAll(topics);
	}

	@Override
	public Topic save(Topic topic) {
		
		return topicRepository.save(topic);
	}

	@Override
	public void delete(Topic topic) {
		
		topicRepository.delete(topic);
		return;
	}

	@Override
	public Optional<Topic> findById(Long id) {
		return topicRepository.findById(id);
	}

	@Override
	public List<String> findAll() {
		
		return ((List<Topic>)topicRepository.findAll()).stream().map(topic -> topic.getDescription()).collect(Collectors.toList());
	}

}
