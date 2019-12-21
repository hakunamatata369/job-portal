package com.ies.jobportal.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseException extends Throwable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5204693904849439676L;

	protected BaseError error;

	public BaseException() {
		error = new BaseError();
		error.setErrorCode("0");
		error.setErrorMessage("SUCCESS");
		error.setStatusCode(200);
	}

	public BaseException(String paramString) {
		super(paramString);
	}

	public BaseException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}

	public BaseException(Throwable paramThrowable) {
		super(paramThrowable);
	}

	public BaseException(String paramString, Throwable paramThrowable, boolean paramBoolean1, boolean paramBoolean2) {
		super(paramString, paramThrowable, paramBoolean1, paramBoolean2);
	}

	public BaseException(BaseError error) {
		super(error.getErrorMessage());
		this.error = error;
	}
}
