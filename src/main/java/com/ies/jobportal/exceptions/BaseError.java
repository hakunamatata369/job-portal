package com.ies.jobportal.exceptions;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = { "errorCode" })
@NoArgsConstructor
public class BaseError extends Message{

	private String errorCode;
	private String errorMessage;
	private int statusCode;
	
	public BaseError(String errorCode, String errorMessage, int statusCode){
		super(errorCode,errorMessage,statusCode);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}
}
