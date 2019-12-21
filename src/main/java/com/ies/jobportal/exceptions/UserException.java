package com.ies.jobportal.exceptions;

public class UserException extends ServerException{

	private static final long serialVersionUID = 1L;
	
	public UserException(BaseError error) {
		super(error);
	}
	
	public UserException(String value) {
        BaseError baseError = new BaseError();
        baseError.setErrorCode("ERR-User-TYPE-1");
        baseError.setErrorMessage(value);
        this.error = baseError;
        baseError.setStatusCode(500);
    }

}
