package com.admin.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.app.entity.Flight;
import com.admin.app.repo.IFlightRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
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

}
