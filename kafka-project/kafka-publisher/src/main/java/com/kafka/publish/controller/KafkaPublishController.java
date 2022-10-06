package com.kafka.publish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.publish.entity.User;

@RestController
public class KafkaPublishController {
	
	@Autowired
	public KafkaTemplate<String, Object> kafkaTemplate;
	
	private String topic = "spring-kafka-1";
	
	@GetMapping("/publish/{name}")
	public String publishMessage(@PathVariable String name) {
		kafkaTemplate.send(topic, "Hi "+name+" This is to inform, that this message is coming from kafka publisher");
		return "data has been publish";
	}
	
	@GetMapping("/publishjson")
	public String publishMessage() {
		User user = new User(101,"Pankaj Yadav","Indore");
		kafkaTemplate.send(topic, user);
		return "Json Data Has Been Published";
	}

}
