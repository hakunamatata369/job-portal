package com.ies.jobportal.exceptions;

public class CompanyException extends ServerException{

	private static final long serialVersionUID = 1L;

	public CompanyException(BaseError error) {
        super(error);
    }

    public CompanyException() {
        BaseError baseError = new BaseError();
        baseError.setErrorCode("ERR-Company-TYPE-1");
        baseError.setErrorMessage("Company Type Exception!!!");
        this.error = baseError;
        baseError.setStatusCode(500);
    }
    
    public CompanyException(String value) {
        BaseError baseError = new BaseError();
        baseError.setErrorCode("ERR-Company-TYPE-1");
        baseError.setErrorMessage(value);
        this.error = baseError;
        baseError.setStatusCode(500);
    }
}
