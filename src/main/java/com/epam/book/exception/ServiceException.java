package com.epam.book.exception;

import lombok.Getter;
import lombok.Setter;

public class ServiceException extends Exception {

	@Getter
	@Setter
	private int status = 500;

	private static final long serialVersionUID = 6252008437485725655L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, int status) {
		super(message);
		this.status = status;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
}
