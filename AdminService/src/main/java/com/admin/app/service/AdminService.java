package com.admin.app.service;

import java.util.List;

import com.admin.app.entity.Flight;

public interface AdminService {

	Flight registerAirline(Flight flight);

	List<Flight> getAllFlightDetails();

}
