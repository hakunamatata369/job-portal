package com.ies.jobportal.response;

import java.util.ArrayList;
import java.util.List;

import com.ies.jobportal.pojo.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserResponse {

private List<User> userList;
	
	public UserResponse() {
		userList = new ArrayList<User>();
	}
	
	public void addUser(User user){
		userList.add(user);
	}
}
