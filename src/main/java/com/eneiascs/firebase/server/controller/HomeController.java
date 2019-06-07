package com.eneiascs.firebase.server.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eneiascs.firebase.server.service.TopicService;

@Controller
public class HomeController {
	@Resource
	private TopicService topicService;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("topics",topicService.findAll());
		return "index";
	}
}
