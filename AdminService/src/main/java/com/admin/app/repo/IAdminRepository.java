package com.admin.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.app.entity.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Integer>{

}
