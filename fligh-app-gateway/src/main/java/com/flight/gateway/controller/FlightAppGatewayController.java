package com.flight.gateway.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.admin.app.entity.Flight;
import com.user.app.entity.Passenger;
import com.user.app.entity.Ticket;
import com.user.app.entity.User;

@RestController
public class FlightAppGatewayController {
	
	@Autowired
	RestTemplate restTemplate;
	
	/*
	 * @GetMapping("/flights/{flightNumber}") public String
	 * getStudents(@PathVariable Integer flightNumber) {
	 * System.out.println("getting flight details for "+flightNumber);
	 * 
	 * String response = restTemplate.exchange(
	 * "http://flight-admin-service//api/v1.0/flight/airline/{flightnumber}",
	 * HttpMethod.GET ,null,new ParameterizedTypeReference<String>()
	 * {},flightNumber).getBody();
	 * 
	 * System.out.println("Response received as : "+response);
	 * 
	 * return "Flight number "+flightNumber+ "\n flight details "+response; }
	 */
	
	@GetMapping("/flight/{flightNumber}")
	public ResponseEntity<Flight> getFlightdetailById(@PathVariable Integer flightNumber) {
		System.out.println("getting flight details for "+flightNumber);
		
		ResponseEntity<Flight> response = restTemplate.exchange("http://flight-admin-service/api/v1.0/flight/airline/{flightnumber}", HttpMethod.GET
				,null,new ParameterizedTypeReference<Flight>() {},flightNumber);
		
		System.out.println("Response received as : "+response);
		return response;
	}
	
	@GetMapping("/flight")
	public ResponseEntity<List<Flight>> getFlights() {
		ResponseEntity<List<Flight>> response = restTemplate.exchange("http://flight-admin-service/api/v1.0/flight/airline/list", HttpMethod.GET
				,null,new ParameterizedTypeReference<List<Flight>>() {});
		
		System.out.println("Response received as : "+response);
		return response;
	}
	
	@PostMapping("/flight/register")
	public ResponseEntity<Flight> registerFlight(@RequestBody Flight flight) {
		HttpEntity<Flight> requestBody = new HttpEntity<Flight>(flight);
		System.out.println("requestBody:   "+requestBody.getBody());
		ResponseEntity<Flight> response = restTemplate.exchange("http://flight-admin-service/api/v1.0/flight/airline/register", HttpMethod.POST
				,requestBody,new ParameterizedTypeReference<Flight>() {});
		
		System.out.println("Response received as : "+response.getBody());
		return response;
	}
	
	
	@GetMapping("/flight/locations")
	public ResponseEntity<List<Flight>> searchFlightsByDestination(@RequestParam Map<String,String> allParams) {
		
		/*
		 * Map<String, String> params = new HashMap<>(); params.put("flightSource",
		 * flightSource); params.put("email", email);
		 * 
		 * HttpEntity<String> response = restOperations.exchange( urlTemplate,
		 * HttpMethod.GET, entity, String.class, params );
		 * 
		 * String result = restTemplate.getForObject("http://example.com/hotels?state={state}&country={country}", String.class,"NY","USA");
		 */
		
		String source = allParams.get("source");
		String destination = allParams.get("destination");
		ResponseEntity<List<Flight>> response = restTemplate.exchange("http://flight-admin-service/api/v1.0/flight/search?source={source}&destination={destination}",
				HttpMethod.GET,null,new ParameterizedTypeReference<List<Flight>>() {},source,destination);
		
		System.out.println("Response received as : "+response.getBody());
		return response;
	}
	
	
	@PostMapping("/flight/book/{flightNumber}")
	public ResponseEntity<String> bookFlight(@PathVariable Integer flightNumber,@RequestBody List<Passenger> passangerDetails,@RequestParam Map<String,String> userDetails) {
		
		String userName = userDetails.get("userName");
		Integer seatCount = Integer.parseInt(userDetails.get("seatCount"));
		String email = userDetails.get("email");
		System.out.println("IN GATEWAY:  flightNumber:  "+flightNumber+"  passangerDetails:  "+passangerDetails.get(0).getFirstName() +" userName: "+userName+" seatCount: "+seatCount);
		
		ResponseEntity<Flight> flightEntity = restTemplate.exchange("http://flight-admin-service/api/v1.0/flight/airline/{flightnumber}", HttpMethod.GET
				,null,new ParameterizedTypeReference<Flight>() {},flightNumber);
		Integer flightNo     = flightEntity.getBody().getFlightNumber();
		Date flightStartDate = flightEntity.getBody().getStartDateTime();
		Date flightEndDate = flightEntity.getBody().getEndDateTime();
		System.out.println("flight number from fight DB:  "+flightNo);
		
		if (flightNo!=null) {
			HttpEntity<List<Passenger>> request = new HttpEntity<List<Passenger>>(passangerDetails);
			
			ResponseEntity<User> response = restTemplate.exchange("http://flight-user-service/api/v1.0/flight/booking?userName={userName}&seatCount={seatCount}&email={email}",
					HttpMethod.POST,request,new ParameterizedTypeReference<User>() {},userName,seatCount,email);
			
			System.out.println("Response received as : "+response.getBody());
			User user = response.getBody();
			
//			//add ticket details
//			ResponseEntity<User> bookedTicketDetail = restTemplate.exchange("http://flight-user-service/api/v1.0/flight/ticket/{pnr}",
//					HttpMethod.POST,request,new ParameterizedTypeReference<User>() {},userName,seatCount,email);
			
			String responseMsg = user.getSeatCount()+" Ticket has been "+user.getTicketStatus()+" with PNR: "+user.getPNRnumber()+" for the user: "+user.getUserName();
			
			return new ResponseEntity<String>(responseMsg, HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Flight does not exists",HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/flight/ticket/{pnr}")
	public ResponseEntity<List<Ticket>> pnrDetail(@PathVariable Integer pnr) {
		ResponseEntity<List<Ticket>> bookedTicketDetail = restTemplate.exchange(
				"http://flight-user-service/api/v1.0/flight/ticket/{pnr}", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Ticket>>() {}, pnr);
		return bookedTicketDetail;
	}
	
	@DeleteMapping("/flight/ticket/{pnr}")
	public ResponseEntity<List<Ticket>> cancelTicket(@PathVariable Integer pnr) {
		ResponseEntity<List<Ticket>> cancelledTicketDetail = restTemplate.exchange(
				"http://flight-user-service/api/v1.0/flight/booking/cancel/{pnr}", HttpMethod.DELETE, null,
				new ParameterizedTypeReference<List<Ticket>>() {}, pnr);
		System.out.println("cancelledTicketDetail: "+cancelledTicketDetail.getBody());
		return cancelledTicketDetail;
	}
	
}
