package com.user.app.repo;
//
//import java.util.List;
//import org.springframework.data.jpa.repository.Query;
//import com.admin.app.entity.Flight;
//import com.user.app.entity.Passenger;
//

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.app.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
}
//
////	@Query(value = "SELECT * FROM flight WHERE (flight_source = ?1 AND flight_destination = ?2);",nativeQuery = true)
////	List<Flight> findFlightBtweenDestinations(String source, String destination);
//
//	@Query(value = "SELECT * FROM passenger WHERE (flight_source = ?1 AND flight_destination = ?2);",nativeQuery = true)
//	List<Passenger> findPNRdetail(Integer pnrNo);
//	
//}
