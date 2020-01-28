package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UpdateUserError extends Exception
{
	public UpdateUserError(String errorKey)
	{
		super(errorKey);

	}

}
