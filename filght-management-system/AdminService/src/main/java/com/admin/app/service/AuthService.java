package com.admin.app.service;

import com.admin.app.entity.Admin;
import com.admin.app.entity.AuthenticationToken;

public interface AuthService {

	void saveConfirmationToken(AuthenticationToken authToken);

	AuthenticationToken getToken(Admin admin);

}
