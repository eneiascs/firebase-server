package com.eneiascs.firebase.server;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.eneiascs.firebase.server.domain.Topic;
import com.eneiascs.firebase.server.repository.TopicRepository;
import com.eneiascs.firebase.server.service.TopicService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@SpringBootApplication
public class FirebaseServerApplication {
	
	@Resource
	private TopicService topicService;
	
	public static void main(String[] args) {
		SpringApplication.run(FirebaseServerApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void setupFirebase() {
		

		try {
		
			FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");
			
			FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.setDatabaseUrl("https://teste-9e939.firebaseio.com").build();
			FirebaseApp fbapp = FirebaseApp.initializeApp(options);
			System.out.println("Inicializou o firebase: " + fbapp.getName() + " - " + fbapp.getOptions().getProjectId()
					+ " - " + fbapp.getOptions().getServiceAccountId() + " - " + fbapp.getOptions().getDatabaseUrl());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void initDatabase() {
		

		List<Topic> topics = new ArrayList<>();
		topics.add(new Topic("bomdia", "Bom dia"));
		topics.add(new Topic("boatarde", "Boa Tarde"));
		topics.add(new Topic("boanoite", "Boa noite"));
		topicService.save(topics);
		
	}
}
