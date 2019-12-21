package com.ies.jobportal.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ServerException extends BaseException{


	private static final long serialVersionUID = 1L;

	public ServerException(BaseError error) {
		super(error);
	}

	public ServerException(String message) {
		BaseError baseError = new BaseError();
		baseError.setErrorCode("ERR-ROLEF-1");
		baseError.setErrorMessage(message);
		this.error = baseError;
		baseError.setStatusCode(500);
	}
}
