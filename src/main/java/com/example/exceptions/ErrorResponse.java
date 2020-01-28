package com.example.exceptions;

import java.util.List;

public class ErrorResponse
{

	private String message;

	private List<String> details;

	public ErrorResponse(String errorKey, List<String> details)
	{
		super();
		this.message = message;
		this.details = details;
	}

}
