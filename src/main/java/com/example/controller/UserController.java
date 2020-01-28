package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

		usersList = userService.getActivteUsers('Y');

		if (usersList != null && usersList.size() == 0)
		{
			return ResponseEntity.ok().body("No Users Found");
		}
		else
		{

			return ResponseEntity.ok().body(userService.getUsers());
		}

	}

	@GetMapping("users/active")
	public ResponseEntity<Object> getActiveUser()
	{

		List<UserEntity> usersList = null;

		usersList = userService.getActivteUsers('Y');

		if (usersList != null && usersList.size() == 0)
		{
			return ResponseEntity.ok().body("No Active Users Found");
		}
		else
		{

			return ResponseEntity.ok().body(userService.getActivteUsers('Y'));
		}

	}

	@GetMapping("users/email/{email}")
	public ResponseEntity<Object> getUsersByEmail(
		@PathVariable("email") String email)
	{
		List<UserEntity> usersList = null;

		usersList = userService.getActivteUsers('Y');

		if (usersList != null && usersList.size() == 0)
		{
			return ResponseEntity.ok().body("No Users Found");
		}
		else
		{

			return ResponseEntity.ok()
				.body(userService.getUsersByEmail(email));
		}

	}
	@PostMapping("/user/{firstName}/{lastName}/{email}/{password}/{address}/{phoneNo}/{createdBy}/{roleName}")
	public void addUser(@PathVariable("firstName") String firstName,
		@PathVariable("lastName") String lastName,
		@PathVariable("email") String email,
		@PathVariable("password") String password,
		@PathVariable("address") String address,
		@PathVariable("phoneNo") String phoneNo,
		@PathVariable("createdBy") String createdBy,
		@PathVariable("roleName") String roleName) throws UserCreationFailed
	{
		UserEntity localUserEntity = new UserEntity();

		localUserEntity.setFirstName(firstName);
		localUserEntity.setLastName(lastName);
		localUserEntity.setEmail(email);
		localUserEntity.setPassword(password);
		localUserEntity.setAddress(address);
		localUserEntity.setPhoneNo(phoneNo);
		localUserEntity.setCreatedBy(createdBy);
		try
		{
			localUserEntity = userService.addUser(localUserEntity, roleName);
		}
		catch (Exception e)
		{
			throw new UserCreationFailed(
				"Unable to Create User");
		}

	}

	@PostMapping("/user/{roleName}")
	public void addUser(@RequestBody UserEntity userEntity,
		@PathVariable("roleName") String roleName) throws UserCreationFailed
	{
		UserEntity localUserEntity = null;
		try
		{
			localUserEntity = userService.addUser(localUserEntity, roleName);
		}
		catch (Exception e)
		{
			throw new UserCreationFailed(
				"Unable to Create User");
		}
	}

	@PostMapping("/user")
	public ResponseEntity<UserEntity> addUsers(
		@RequestBody UserEntity userEntity,
		@RequestParam("roleName") String roleName) throws UserCreationFailed
	{
		UserEntity localUserEntity = null;
		try
		{
			localUserEntity = userService.addUser(userEntity, roleName);
		}
		catch (Exception e)
		{
			throw new UserCreationFailed(
				"error.unable.to.add.user");
		}

		return ResponseEntity.ok().body(localUserEntity);
	}

	@PutMapping("/user")
	public ResponseEntity<UserEntity> updateUser(
		@RequestParam("firstName") String firstName,
		@RequestParam("address") String address) throws UpdateUserError
	{
		UserEntity localUserEntity = null;
		try
		{
			localUserEntity = userService.updateUser(firstName, address);
		}
		catch (Exception e)
		{
			throw new UpdateUserError(
				"error.update.user.issue");
		}

		return ResponseEntity.ok().body(localUserEntity);
	}

	@PutMapping("/user/inactive")
	public ResponseEntity<UserEntity> inActiveUser(
		@RequestParam("firstName") String firstName) throws UpdateUserError
	{
		UserEntity localUserEntity = null;
		try
		{
			System.out.println(firstName);
			
			localUserEntity = userService.inActiveUser(firstName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			throw new UpdateUserError(
				"error.update.user.issue");
		}

		return ResponseEntity.ok().body(localUserEntity);
	}
}
