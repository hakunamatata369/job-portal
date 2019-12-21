package com.ies.jobportal.dao.converters;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ies.jobportal.dao.entity.UserEntity;
import com.ies.jobportal.pojo.User;

@Component
@ConfigurationPropertiesBinding
public class UserEntityConverter implements Converter<UserEntity, User>{

	@Override
	public User convert(UserEntity userEntity) {
		User user = User.builder().userId(userEntity.getUserId())
				.firstName(userEntity.getFirstName()).middleName(userEntity.getMiddleName())
				.avatar(userEntity.getAvatar())
				.lastName(userEntity.getLastName()).emailId(userEntity.getEmailId()).build();
		return user;
	}

}
