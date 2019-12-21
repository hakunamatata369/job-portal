package com.ies.jobportal.config;

import org.springframework.stereotype.Component;

import com.ies.jobportal.pojo.UserInfo;

@Component
public class AuthGetInfoByToken {

	public UserInfo getTokenInfo(String token) {
		UserInfo info = new UserInfo(4L,2L);
		return info;
	}

}
