package com.user.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.admin.app.entity.Flight;
import com.admin.app.repo.IFlightRepository;
import com.user.app.entity.Passenger;
import com.user.app.entity.User;
import com.user.app.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
//	@Autowired(required = false)
//	User user;

//	@Override
//	public List<Flight> getAllFlightes() {
//		flightRepository.findAll();
//		return null;
//	}
//
//
//	@Override
//	public List<Flight> flightServiceBtweenDestinations(String source, String destination) {
//		List<Flight> flightLists =  flightRepository.findFlightBtweenDestinations(source, destination);
//		System.out.println("flightList "+flightLists+" on the basis of source: "+source+" destination: "+destination);
//		return flightLists;
//	}


	@Override
	public User bookFlight(Integer flightPNR, String tktStatus, String userName, Integer seatCount, String email) {
//		Optional<Flight> flightOp = flightRepository.findById(flightNumber);
//		Flight flightResult = flightOp.get();
//		Integer flightNo = flightResult.getFlightNumber();
		
		User user = new User();
		user.setUserName(userName);
		user.setSeatCount(seatCount);
		user.setEmail(email);
		user.setPNRnumber(flightPNR);
		user.setTicketStatus(tktStatus);
		userRepository.save(user);
		return user;
	}


//	@Override
//	public List<Passenger> getDetailsAgainstPNRnumber(Integer pnrNo) {
//		userRepository.findPNRdetail(pnrNo);
//		return null;
//	}


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
