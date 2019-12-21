package com.ies.jobportal.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserInfo {
	private Long userId;
	private Long companyId;
	private String email;
	@JsonIgnore
	private String password;
	
	public UserInfo(Long userId,Long companyId){
		this.userId = userId;
		this.companyId = companyId;
	}
}