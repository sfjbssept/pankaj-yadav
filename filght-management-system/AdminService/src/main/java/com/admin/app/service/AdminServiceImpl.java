package com.admin.app.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Objects;

import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.app.entity.Admin;
import com.admin.app.entity.AuthenticationToken;
import com.admin.app.exceptions.AuthenticationFailException;
import com.admin.app.exceptions.CustomException;
import com.admin.app.repo.IAdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	IAdminRepository adminRepo;

	@Autowired
	AuthService authService;

	@Override
	@Transactional
	public void signUpAdmin(Admin adminDetails) {
		// check if user already present
		if (Objects.nonNull(adminRepo.findbyEmail(adminDetails.getEmail()))) {
			throw new CustomException("User already present");
		}
		// hash the password
		try {
			String encryPswd = hashPassword(adminDetails.getPassword());
			// save the Admin
			Admin admin = new Admin();
			admin.setEmail(adminDetails.getEmail());
			admin.setPassword(encryPswd);
			admin.setAdminName(adminDetails.getAdminName());
			admin.setAdminLastName(adminDetails.getAdminLastName());
			adminRepo.save(admin);

			// create the token
			final AuthenticationToken authToken = new AuthenticationToken(admin);
			authService.saveConfirmationToken(authToken);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	private String hashPassword(String encryPswd) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(encryPswd.getBytes());
		byte[] digest = md.digest();
		String hash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		return hash;
	}

	@Override
	public String signInAdmin(Map<String, String> allParams) {
		// find user by email
		String requestEmail = allParams.get("email");
		System.out.println("requestEmail:   ====> "+requestEmail);
		Admin admin = adminRepo.findbyEmail(requestEmail);
		if (Objects.isNull(adminRepo.findbyEmail(requestEmail))) {
			throw new AuthenticationFailException("Admin user is not valid");
		}
//		if (!admin.getPassword().equals(allParams.get("password"))) {
//			throw new AuthenticationFailException("wrong password");
//		}
		// compare the password in DB, if matches then retrieve the token and return the
		// response
		AuthenticationToken token = authService.getToken(admin);
		String tokenResponse = token.getToken();
		if (Objects.isNull(token)) {
			throw new CustomException("Token is not present");
		}
		return tokenResponse;
	}

}
