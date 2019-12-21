package com.ies.jobportal.dao.converters;

import org.springframework.core.convert.converter.Converter;

import com.ies.jobportal.dao.entity.UserEntity;
import com.ies.jobportal.pojo.User;

public class UserToEntityConverter implements Converter<User, UserEntity>{

	@Override
	public UserEntity convert(User user) {
		UserEntity userEntity = UserEntity.builder().userId(user.getUserId())
				.firstName(user.getFirstName()).middleName(user.getMiddleName())
				.avatar(user.getAvatar())
				.lastName(user.getLastName()).emailId(user.getEmailId()).build();
		return userEntity;
	}

}
