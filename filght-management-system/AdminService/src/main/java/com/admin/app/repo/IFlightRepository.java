package com.admin.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.app.entity.Flight;

public interface IFlightRepository extends JpaRepository<Flight, Integer>{

}
