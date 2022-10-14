package com.admin.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.app.entity.Admin;
import com.admin.app.entity.Flight;
import com.admin.app.repo.IFlightRepository;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	IFlightRepository flightRepository;

	@Override
	public Flight registerAirline(Flight flight) {
		Flight registeredFlight = flightRepository.save(flight);
		return registeredFlight;
	}

	@Override
	public List<Flight> getAllFlightDetails() {
		List<Flight> flightList= flightRepository.findAll();
		return flightList;
	}

	@Override
	public Optional<Flight> getFLightbyId(Integer id) {
		Optional<Flight> flight = flightRepository.findById(id);
		return flight;
	}

	@Override
	public void deleteFlight(Integer id) {
		flightRepository.deleteById(id);
	}
	
	@Override
	public List<Flight> flightServiceBtweenDestinations(String source, String destination) {
		List<Flight> flightLists =  flightRepository.findFlightBtweenDestinations(source, destination);
		System.out.println("flightList "+flightLists+" on the basis of source: "+source+" destination: "+destination);
		return flightLists;
	}


//	@Override
//	public Boolean bookFlight(Integer flightNumber, String email, Integer seatCount, String email2) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
