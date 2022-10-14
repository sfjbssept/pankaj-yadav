package com.user.app.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.admin.app.entity.Flight;
import com.user.app.entity.Passenger;
import com.user.app.entity.User;


public interface UserService {
	
//	List<Flight> getAllFlightes();
//	List<Flight> getAllFlightesByKey(Object obj);
//	List<Flight> getAllFlightesByKey(Map<String, String> obj);
//	List<Flight> flightServiceBtweenDestinations(String source, String destination);
	User bookFlight(Integer flightPNR,String tktStatus, String userName, Integer seatCount, String email);
//	List<Passenger> getDetailsAgainstPNRnumber(Integer pnrNo);
}
