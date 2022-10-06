package com.rabbit.producer;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbit.config.MessagingConfig;
import com.rabbit.entity.Employee;
import com.rabbit.entity.EmployeeStatus;

@RestController
@RequestMapping("/Employee")
public class EmployeePublisher {
	
	@Autowired
	RabbitTemplate restTemplate;
	
	@PostMapping("/")
	public String saveEmployee(@RequestBody Employee employee) {
		employee.setEmpId(UUID.randomUUID().toString());
		
		EmployeeStatus empStatus = new EmployeeStatus(employee,"joined","Has recently joined the office and going through the onboarding process in ");
		restTemplate.convertAndSend(MessagingConfig.EXCHANGENAME, MessagingConfig.ROUTING_KEY, empStatus);
		return "Success";
	}

}
