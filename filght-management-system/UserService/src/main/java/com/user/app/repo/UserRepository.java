package com.user.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT * FROM passenger WHERE (flight_source = ?1 AND flight_destination = ?2);",nativeQuery = true)
	List<Passenger> findPNRdetail(Integer pnrNo);

}
