package com.ies.jobportal.exceptions;

public class InterviewException extends ServerException {

	private static final long serialVersionUID = 1L;

	public InterviewException(BaseError error) {
        super(error);
    }
	
	public InterviewException(String value) {
        BaseError baseError = new BaseError();
        baseError.setErrorCode("ERR-INTERVIEW-TYPE-1");
        baseError.setErrorMessage(value);
        this.error = baseError;
        baseError.setStatusCode(500);
    }
}
