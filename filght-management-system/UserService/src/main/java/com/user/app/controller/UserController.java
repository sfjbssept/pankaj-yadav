package com.user.app.controller;

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

import com.admin.app.entity.Flight;
import com.user.app.entity.ListPassenger;
import com.user.app.entity.Passenger;
import com.user.app.entity.User;
import com.user.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
//	public ResponseEntity<List<Flight>> searchFlight(@RequestParam Map<String,String> allParams){
//		List<Flight> responseFlightList = null;
//		//userService.
//		Set<Entry<String,String>> paramSet = allParams.entrySet();
//		Iterator<Entry<String, String>> itr = paramSet.iterator();
//		while(itr.hasNext()) {
//			Entry<String, String> paramEntry = itr.next();
////			if(paramEntry.getKey().equals(paramEntry))
//			responseFlightList = userService.getAllFlightesByKey(paramEntry.getValue());
//			}
//		return new ResponseEntity<List<Flight>>(responseFlightList,HttpStatus.OK);
//	}
	
//	@GetMapping("/api/v1.0/flight/search")
//	public ResponseEntity<List<Flight>> searchFlight(@RequestParam Map<String,String> allParams){
//		List<Flight> responseFlightList = null;
//		System.out.println("allParams: "+allParams);
//		if(allParams.containsKey("source") && allParams.containsKey("destination")) {
//			responseFlightList = userService.flightServiceBtweenDestinations(allParams.get("source"), allParams.get("destination"));
//			System.out.println("Source is: "+allParams.get("source")+" \n destination is "+allParams.get("destination"));
//		}
//		return new ResponseEntity<List<Flight>>(responseFlightList,HttpStatus.OK);
//	}
	
	@PostMapping("/api/v1.0/flight/booking/{flightNumber}")
	public ResponseEntity<String> bookFlight(@PathVariable Integer flightNumber,@RequestBody List<Passenger> passangerDetails,@RequestParam Map<String,String> userDetails){
		String userName = userDetails.get("userName");
		Integer seatCount = Integer.parseInt(userDetails.get("seatCount"));
		String email = userDetails.get("email");
		System.out.println("flightNumber:  "+flightNumber+"  passangerDetails:  "+passangerDetails +"userName: "+userName+" seatCount: "+seatCount);
//		return null;
		User user =  userService.bookFlight(flightNumber, passangerDetails, email, seatCount, email);
		String responseMsg = user.getSeatCount()+"Ticket has been "+user.getTicketStatus()+" with PNR: "+user.getPNRnumber()+" for the user"+user.getUserName();
//		return ResponseEntity.of(searchedFlight);
		return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
	}
	
//	@GetMapping("/api/v1.0/flight/ticket/{pnr}")
//	public ResponseEntity<List<Passenger>> getPNRdetails(@PathVariable Integer pnrNo){
//		List<Passenger> passangerList = null;
//		userService.getDetailsAgainstPNRnumber(pnrNo);
//		return new ResponseEntity<List<Passenger>>(responseFlightList,HttpStatus.OK);
//	}
	
}
