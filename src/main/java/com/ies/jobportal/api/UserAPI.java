package com.ies.jobportal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.jobportal.exceptions.CompanyException;
import com.ies.jobportal.exceptions.UserException;
import com.ies.jobportal.exceptions.UserIdNotFoundException;
import com.ies.jobportal.request.UserRequest;
import com.ies.jobportal.response.UserResponse;
import com.ies.jobportal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserAPI {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<UserResponse> createOrUpdateUser(@RequestHeader(name = "auth-token") String token,@RequestBody UserRequest request) throws UserException, CompanyException {
		
		UserResponse response = userService.createOrUpdateUser(request,token);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable("userId") Long userId) throws UserException, UserIdNotFoundException {
		UserResponse response = userService.getUserById(userId);
		return ResponseEntity.ok(response);

	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<UserResponse> deleteUser(@PathVariable("userId") Long userId) throws UserException, UserIdNotFoundException {
		UserResponse response = userService.deleteUser(userId);
		return ResponseEntity.ok(response);
	}
}
