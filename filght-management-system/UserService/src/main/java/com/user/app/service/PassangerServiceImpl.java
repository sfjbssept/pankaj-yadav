package com.user.app.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.user.app.entity.Passenger;
import com.user.app.repo.PassangerRepository;

@Service
public class PassangerServiceImpl implements PassangerService{
	
	@Autowired
	PassangerRepository passangerRepository;

	@Override
	public void addPassanger(Integer pnrNo, List<Passenger> passangerDetails) {
		List<Passenger> passangerList = new ArrayList<>();
		
		ListIterator<Passenger> iterator = passangerDetails.listIterator();
		while (iterator.hasNext()) {
			Passenger p = iterator.next();
			p.setPNRnumber(pnrNo);
			passangerList.add(p);
		}
		passangerRepository.saveAll(passangerList);
	}

	@Override
	public List<Passenger> getPassangers() {
		List<Passenger> passangers = passangerRepository.findAll();
		return passangers;
	}

}
