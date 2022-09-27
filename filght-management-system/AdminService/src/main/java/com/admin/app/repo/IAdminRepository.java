package com.admin.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.app.entity.Admin;

@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{

}
