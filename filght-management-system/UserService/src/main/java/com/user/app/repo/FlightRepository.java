package com.user.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.admin.app.entity.Flight;

@Repository
public interface UserRepository extends JpaRepository<Flight, Integer> {

	@Query(value = "SELECT * FROM flight WHERE (flight_source = ?1 AND flight_destination = ?2);",nativeQuery = true)
	List<Flight> findFlightBtweenDestinations(String source, String destination);
	
}
