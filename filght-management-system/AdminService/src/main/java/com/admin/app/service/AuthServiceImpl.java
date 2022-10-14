package com.admin.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.app.entity.AuthenticationToken;
import com.admin.app.repo.TokenRepository;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	TokenRepository tokenRepo;

	public void saveConfirmationToken(AuthenticationToken authToken) {
		tokenRepo.save(authToken);
	}

}
