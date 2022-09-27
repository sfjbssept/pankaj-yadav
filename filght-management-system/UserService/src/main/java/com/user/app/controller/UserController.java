package com.user.app.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.admin.app.entity.Flight;
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
	
	@GetMapping("/api/v1.0/flight/search")
	public ResponseEntity<List<Flight>> searchFlight(@RequestParam Map<String,String> allParams){
		List<Flight> responseFlightList = null;
		System.out.println("allParams: "+allParams);
		if(allParams.containsKey("source") && allParams.containsKey("destination")) {
			responseFlightList = userService.flightServiceBtweenDestinations(allParams.get("source"), allParams.get("destination"));
			System.out.println("Source is: "+allParams.get("source")+" \n destination is "+allParams.get("destination"));
		}
		return new ResponseEntity<List<Flight>>(responseFlightList,HttpStatus.OK);
	}
	
	@PostMapping("/api/v1.0/flight/booking/{flightid}")
	public ResponseEntity<Flight> bookFlight(@PathVariable Integer flightId){
		return new ResponseEntity<Flight>(userService.findFlight(flightId),HttpStatus.ACCEPTED);
		//return new ResponseEntity<List<Flight>>(responseFlightList,HttpStatus.OK);
	}
	
}
