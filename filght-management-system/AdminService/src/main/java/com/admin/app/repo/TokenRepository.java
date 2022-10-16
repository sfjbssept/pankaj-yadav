package com.admin.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.admin.app.entity.AuthenticationToken;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer> {
	
	@Query(value = "SELECT * FROM auth_tokens WHERE admin_id = ?;",nativeQuery = true)
	AuthenticationToken findByAdminUserId(Integer adminId);
}
