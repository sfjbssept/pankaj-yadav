package com.user.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.app.entity.Passenger;

@Repository
public interface PassangerRepository extends JpaRepository<Passenger, Integer>{

}
