package com.ies.jobportal.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ies.jobportal.exceptions.BaseException;
import com.ies.jobportal.pojo.Company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse implements Serializable {
	private static final long serialVersionUID = 4917942627313026465L;

	@JsonIgnore
	private Company company;
	private BaseException exception = null;
	private String message;
	private String messageId;

	public BaseResponse(String message) {
		this.message = message;
	}

	public BaseResponse(String message, String messageId) {
		this.message = message;
		this.messageId = messageId;
	}
}
