package com.admin.app.service;

import java.util.List;
import java.util.Optional;

import com.admin.app.entity.Flight;

public interface AdminService {

	Flight registerAirline(Flight flight);

	List<Flight> getAllFlightDetails();
	
	Optional<Flight> getFLightbyId(Integer id);
	
	void deleteFlight(Integer id);
	
	List<Flight> flightServiceBtweenDestinations(String source, String destination);

	//Boolean bookFlight(Integer flightNumber, String email, Integer seatCount, String email2);

}
