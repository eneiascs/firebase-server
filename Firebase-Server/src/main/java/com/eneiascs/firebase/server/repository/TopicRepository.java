package com.eneiascs.firebase.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eneiascs.firebase.server.domain.Topic;

public interface TopicRepository extends CrudRepository<Topic, Long> {

	List<Topic> findByName(String topic);

}
