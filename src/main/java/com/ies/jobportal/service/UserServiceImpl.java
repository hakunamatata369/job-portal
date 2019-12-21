package com.ies.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.ies.jobportal.config.AuthGetInfoByToken;
import com.ies.jobportal.dao.UserRepository;
import com.ies.jobportal.dao.entity.CompanyEntity;
import com.ies.jobportal.dao.entity.UserEntity;
import com.ies.jobportal.exceptions.CompanyException;
import com.ies.jobportal.exceptions.UserException;
import com.ies.jobportal.exceptions.UserIdNotFoundException;
import com.ies.jobportal.pojo.Company;
import com.ies.jobportal.pojo.User;
import com.ies.jobportal.pojo.UserInfo;
import com.ies.jobportal.request.UserRequest;
import com.ies.jobportal.response.UserResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ConversionService conversionService;
	
	@Autowired
	private AuthGetInfoByToken getUserInfo;
	
	@Override
	public UserResponse findUserByCompany(String token) throws UserException {
		UserInfo tokenInfo = getUserInfo.getTokenInfo(token);
		
		List<UserEntity> userEntities = userRepository.findByCompany(tokenInfo.getCompanyId());
		UserResponse response = new UserResponse();
		
		for(UserEntity userEntity : userEntities) {
			User user = conversionService.convert(userEntity, User.class);
			user.setCompany(conversionService.convert(userEntity.getCompany(), Company.class));
			response.addUser(user);
		}
		return response;
	}

	@Override
	public UserResponse createOrUpdateUser(UserRequest request, String token) throws UserException, CompanyException {
		if (null == request || null == request.getUser() )
			throw new UserException("User can't be null");
		
		if( request.getUser().getCompany() == null)
			throw new CompanyException();
		
		UserEntity userEntity = conversionService.convert(request.getUser(), UserEntity.class);
		userEntity.setCompany(conversionService.convert(request.getUser().getCompany(),CompanyEntity.class));
		
		UserEntity retrievedUserEntity = userRepository
				.saveAndFlush(userEntity);

		User user = conversionService.convert(retrievedUserEntity, User.class);

		UserResponse response = new UserResponse();
		response.addUser(user);
		return response;
	}

	@Override
	public UserResponse deleteUser(Long userId) throws UserException, UserIdNotFoundException {
		if (null == userId)
			throw new UserException("user id can't be null");

		if (!userRepository.existsById(userId))
			throw new UserIdNotFoundException("No User Exists to delete");

		userRepository.deleteById(userId);

		UserResponse response = new UserResponse();
		return response;
	}

	@Override
	public UserResponse getUserById(Long userId) throws UserException, UserIdNotFoundException {
		if (null == userId)
			throw new UserException("user id can't be null");

		if (!userRepository.existsById(userId))
			throw new UserIdNotFoundException("No User Exists to retrieve");
		
		UserResponse response = new UserResponse();
		return response;
	}

}
