package com.example.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.controller.UpdateUserError;

@ControllerAdvice
public class CustomExceptionHandler
{

	@ExceptionHandler(UserCreationFailed.class)
	public final ResponseEntity<Object> unableToAddUserException(
		UserCreationFailed ex, WebRequest request)
	{
		List<String> details = new ArrayList<>();

		details.add(ex.getLocalizedMessage());

		ErrorResponse error = new ErrorResponse(
			ex.getMessage(),
			details);

		return new ResponseEntity(
			error,
			HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UpdateUserError.class)
	public final ResponseEntity<Object> unabletoUpdateUser(
		UpdateUserError ex, WebRequest request)
	{
		List<String> details = new ArrayList<>();

		details.add(ex.getLocalizedMessage());

		ErrorResponse error = new ErrorResponse(
			ex.getMessage(),
			details);

		return new ResponseEntity(
			error,
			HttpStatus.NOT_MODIFIED);
	}

}
