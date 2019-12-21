package com.ies.jobportal.exceptions;

public class UserIdNotFoundException extends ServerException {

private static final long serialVersionUID = 1L;
	
	public UserIdNotFoundException(BaseError error) {
		super(error);
	}
	
	public UserIdNotFoundException(String value) {
        BaseError baseError = new BaseError();
        baseError.setErrorCode("ERR-User-TYPE-2");
        baseError.setErrorMessage(value);
        this.error = baseError;
        baseError.setStatusCode(500);
    }
}
