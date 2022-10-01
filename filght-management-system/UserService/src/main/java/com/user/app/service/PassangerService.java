package com.user.app.service;

import java.util.List;

import com.user.app.entity.Passenger;

public interface PassangerService {

	void addPassanger(Integer pnrNo, List<Passenger> passangerDetails);

	List<Passenger> getPassangers();

}
