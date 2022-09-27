package com.user.app.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.admin.app.entity.Flight;
import com.user.app.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Flight> getAllFlightes() {
		userRepository.findAll();
		return null;
	}


	@Override
	public List<Flight> flightServiceBtweenDestinations(String source, String destination) {
		List<Flight> flightLists =  userRepository.findFlightBtweenDestinations(source, destination);
		System.out.println("flightList "+flightLists+" on the basis of source: "+source+" destination: "+destination);
		return flightLists;
	}


	@Override
	public Flight findFlight(Integer flightId) {
		userRepository.findById(flightId);
		return null;
	}


	

	

//	@Override
//	public List<Flight> getAllFlightesByKey(Map<String,String> obj) {
////		List<Flight> responseFlightList = null;
//		Set<Entry<String,String>> paramSet = obj.entrySet();
//		Iterator<Entry<String, String>> itr = paramSet.iterator();
//		while(itr.hasNext()) {
//			Entry<String, String> paramEntry = itr.next();
//			Example<Entry<String, String>> flightExample =  Example.of(paramEntry);
//			userRepository.findAll(flightExample);
//			//userRepository.find
//			}
//		return null;
//	}
	
}
