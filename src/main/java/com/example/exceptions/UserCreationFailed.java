package com.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserCreationFailed extends Exception
{

	public UserCreationFailed(String string)
	{
		super(string);
	}
}
