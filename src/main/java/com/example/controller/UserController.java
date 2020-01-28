package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.UserEntity;
import com.example.exceptions.UserCreationFailed;
import com.example.services.UserService;

@RestController
@RequestMapping("userApi")
public class UserController
{
	@Autowired
	private UserService userService;

	@GetMapping("users")
	public ResponseEntity<Object> getUsers()
	{
		List<UserEntity> usersList = null;

		usersList = userService.getUsers();

		if (CollectionUtils.isEmpty(usersList))
		{
			return ResponseEntity.ok().body("No Users Found");
		}
		else
		{
			return ResponseEntity.ok().body(userService.getUsers());
		}

	}
	@GetMapping("activeUsers")
	public ResponseEntity<Object> getActiveUser()
	{
		List<UserEntity> usersList = null;

		usersList = userService.getActivteUsers();

		if (usersList != null && usersList.size() == 0)
		{
			return ResponseEntity.ok().body("No Active Users Found");
		}
		else
		{

			return ResponseEntity.ok().body(userService.getActivteUsers());
		}

	}

	@GetMapping("users/{email}")
	public ResponseEntity<Object> getUserByEmail(
		@PathVariable("email") String email)
	{
		UserEntity userEntity = null;

		userEntity = userService.getUserByEmail(email);

		if (userEntity != null)
		{
			return ResponseEntity.ok().body("No Users Found with this mail");
		}
		else
		{

			return ResponseEntity.ok().body(userService.getUserByEmail(email));
		}

	}

	@PostMapping("/users")
	public void registerUser(@RequestBody UserEntity userEntity)
		throws UserCreationFailed
	{
		UserEntity localUserEntity = null;
		try
		{
			localUserEntity = userService.registerUser(localUserEntity);
		}
		catch (Exception e)
		{
			throw new UserCreationFailed(
				"Unable to Register User");
		}
	}
	@PutMapping("/users")
	public ResponseEntity<String> updateUser(
		@RequestBody UserEntity userEntity) throws UpdateUserError
	{
		try
		{
			userService.updateUser(userEntity);
		}
		catch (Exception e)
		{
			throw new UpdateUserError(
				"error.update.user.issue");
		}

		return ResponseEntity.ok().body("updated successfully");
	}

	@DeleteMapping("/users/{email}")
	public ResponseEntity<String> deleteUser(
		@PathVariable("email") String email) throws UpdateUserError
	{
		try
		{
			userService.deleteUser(email);
		}
		catch (Exception e)
		{
			throw new UpdateUserError(
				"error.update.user.issue");
		}

		return ResponseEntity.ok().body("updated sucessfully");
	}
}
