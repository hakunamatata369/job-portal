package com.ies.jobportal.exceptions;

public class JobIdNotFoundException extends ServerException {

	private static final long serialVersionUID = 1L;

	public JobIdNotFoundException(BaseError error) {
        super(error);
    }
	
	public JobIdNotFoundException(String value) {
        BaseError baseError = new BaseError();
        baseError.setErrorCode("ERR-Job-TYPE-2");
        baseError.setErrorMessage(value);
        this.error = baseError;
        baseError.setStatusCode(500);
    }
}
