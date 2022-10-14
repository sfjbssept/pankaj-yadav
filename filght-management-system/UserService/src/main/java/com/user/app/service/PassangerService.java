package com.user.app.service;

import java.util.List;
import java.util.Optional;

import com.user.app.entity.Passenger;

public interface PassangerService {

	void addPassanger(Integer pnrNo,String ticketStaus, List<Passenger> passangerDetails);

	List<Passenger> getPassangers();
	Optional<Passenger> getPassengerById(Integer id);
	void deletePassenger(Integer pasId);
	Passenger addPassenger(Passenger passenger);
//	Optional<Passenger> updatePassenger(Passenger passenger);

}
