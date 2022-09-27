package com.user.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.admin.app.entity.Flight;


public interface UserService {
	
	List<Flight> getAllFlightes();
//	List<Flight> getAllFlightesByKey(Object obj);
//	List<Flight> getAllFlightesByKey(Map<String, String> obj);
	List<Flight> flightServiceBtweenDestinations(String source, String destination);
	Flight findFlight(Integer flightId);
}
