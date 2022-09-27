package com.admin.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.app.entity.Flight;

@Repository
public interface IFlightRepository extends JpaRepository<Flight, Integer>{

}
