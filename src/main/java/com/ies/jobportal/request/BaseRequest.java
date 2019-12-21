package com.ies.jobportal.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ies.jobportal.pojo.Company;
import com.ies.jobportal.pojo.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class BaseRequest implements Serializable{
	private static final long serialVersionUID = 3904571708942667961L;
	private User user;
	private Company company;
}
