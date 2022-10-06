package com.com.kafka.consumer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.com.kafka.consumer.entity.User;

@RestController
public class KafkaConsumeController {
	
	List<String> messages = new ArrayList<>();
	User userFromTopic = null;
	
	@GetMapping("/consumestring")
	public List<String> consumeMessages(){
		return messages;
	}
	
	@KafkaListener(groupId = "groupid-1", topics = "spring-kafka1", containerFactory = "kafkaListenerContainerFactory")
	public List<String> getMsgFromTopic(String data){
		messages.add(data);
		return messages;
	}
	
	@GetMapping("/consume/json")
	public User consumeJsonMessages(){
		return userFromTopic;
	}
	
	@KafkaListener(groupId = "groupid-2", topics = "spring-kafka1", containerFactory = "userKafkaListenerContainerFactory")
	public User getJsonMsgFromTopic(User user){
		userFromTopic = user;
		return userFromTopic;
	}
	

}
