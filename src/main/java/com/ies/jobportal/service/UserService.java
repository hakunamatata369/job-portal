package com.ies.jobportal.service;

import com.ies.jobportal.exceptions.CompanyException;
import com.ies.jobportal.exceptions.UserException;
import com.ies.jobportal.exceptions.UserIdNotFoundException;
import com.ies.jobportal.request.UserRequest;
import com.ies.jobportal.response.UserResponse;

public interface UserService {

	UserResponse findUserByCompany(String token) throws UserException;

	UserResponse createOrUpdateUser(UserRequest request, String token) throws UserException, CompanyException;

	UserResponse deleteUser(Long userId) throws UserException, UserIdNotFoundException;

	UserResponse getUserById(Long userId) throws UserException, UserIdNotFoundException;
}
