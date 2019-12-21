package com.ies.jobportal.exceptions;

public class JobException extends ServerException {

	private static final long serialVersionUID = 1L;

	public JobException(BaseError error) {
        super(error);
    }
	
	public JobException(String value) {
        BaseError baseError = new BaseError();
        baseError.setErrorCode("ERR-Job-TYPE-1");
        baseError.setErrorMessage(value);
        this.error = baseError;
        baseError.setStatusCode(500);
    }
}
