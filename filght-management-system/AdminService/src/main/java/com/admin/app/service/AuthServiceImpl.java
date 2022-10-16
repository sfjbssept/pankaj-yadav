package com.admin.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.app.entity.Admin;
import com.admin.app.entity.AuthenticationToken;
import com.admin.app.repo.TokenRepository;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	TokenRepository tokenRepo;

	public void saveConfirmationToken(AuthenticationToken authToken) {
		tokenRepo.save(authToken);
	}

	@Override
	public AuthenticationToken getToken(Admin admin) {
		Integer adminId = admin.getAdminId();
		System.out.println("Admin ID Is : "+adminId);
		AuthenticationToken Authtoken = tokenRepo.findByAdminUserId(adminId);
		return Authtoken;
	}

}
