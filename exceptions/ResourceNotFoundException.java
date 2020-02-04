package com.usermanager.exceptions;

public class ResourceNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String errorMsgArg) {
		super(errorMsgArg);
	}

}
