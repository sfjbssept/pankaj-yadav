package com.admin.app.service;

import java.util.Map;

import com.admin.app.entity.Admin;

public interface AdminService {

	void signUpAdmin(Admin adminDetails);

	String signInAdmin(Map<String, String> allParams);
}
