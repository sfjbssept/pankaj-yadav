package com.user.app.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.entity.Passenger;
import com.user.app.entity.User;
import com.user.app.service.PassangerService;
import com.user.app.service.TicketService;
import com.user.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public PassangerService passangerService;
	
	@Autowired
	TicketService ticketService;
	
	/*
	 * public ResponseEntity<List<Flight>> searchFlight(@RequestParam
	 * Map<String,String> allParams){ List<Flight> responseFlightList = null;
	 * //userService. Set<Entry<String,String>> paramSet = allParams.entrySet();
	 * Iterator<Entry<String, String>> itr = paramSet.iterator();
	 * while(itr.hasNext()) { Entry<String, String> paramEntry = itr.next(); //
	 * if(paramEntry.getKey().equals(paramEntry)) responseFlightList =
	 * userService.getAllFlightesByKey(paramEntry.getValue()); } return new
	 * ResponseEntity<List<Flight>>(responseFlightList,HttpStatus.OK); }
	 * 
	 * @GetMapping("/api/v1.0/flight/search") public ResponseEntity<List<Flight>>
	 * searchFlight(@RequestParam Map<String,String> allParams){ List<Flight>
	 * responseFlightList = null; System.out.println("allParams: "+allParams);
	 * if(allParams.containsKey("source") && allParams.containsKey("destination")) {
	 * responseFlightList =
	 * userService.flightServiceBtweenDestinations(allParams.get("source"),
	 * allParams.get("destination"));
	 * System.out.println("Source is: "+allParams.get("source")
	 * +" \n destination is "+allParams.get("destination")); } return new
	 * ResponseEntity<List<Flight>>(responseFlightList,HttpStatus.OK); }
	 */
	
	@PostMapping("/api/v1.0/flight/booking")
	public ResponseEntity<User> bookFlight(@RequestBody List<Passenger> passangerDetails,@RequestParam Map<String,String> userDetails){
		String userName = userDetails.get("userName");
		Integer seatCount = Integer.parseInt(userDetails.get("seatCount"));
		String email = userDetails.get("email");
		System.out.println("IN USER CONTROLLER:--->  passangerDetails:  "+passangerDetails +" userName: "+userName+" seatCount: "+seatCount);
		
		Integer flightPNR = Integer.valueOf((int) (Math.random()*100000000));
		System.out.println("flightPNR:  "+flightPNR);

		User user =  userService.bookFlight(flightPNR, email, seatCount, email);
		passangerService.addPassanger(flightPNR,passangerDetails);
		for(Passenger passenger : passangerDetails) {
			String seatNumber = passenger.getSeatNumber();
			Date startDate = passenger.getStartDateTime();
			Date endDate = passenger.getEndDateTime();
			ticketService.confirmTicketByPNR(flightPNR, seatNumber, startDate, endDate);
			//start date and end date yet to be added in confirmTicketByPNR to create ticket object.
			//(later we will fetch this ticket with PNR info)
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/api/v1.0/passangers")
	public ResponseEntity<List<Passenger>> searchPassanger() {
		List<Passenger> passangerList = passangerService.getPassangers();
		return new ResponseEntity<List<Passenger>>(passangerList, HttpStatus.OK);
	}
	
	@GetMapping("/api/v1.0/flight/ticket/{pnr}")
	public ResponseEntity<List<Passenger>> getPNRdetails(@PathVariable Integer pnrNo){
		userService.getTicketDetailByPNR(pnrNo);
		return new ResponseEntity<List<Passenger>>(responseFlightList,HttpStatus.OK);
	}
	
}
