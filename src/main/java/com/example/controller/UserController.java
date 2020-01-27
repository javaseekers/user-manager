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
import com.example.services.UserService;

@RestController
@RequestMapping("userApi")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@GetMapping("users")
	public ResponseEntity<List<UserEntity>> getUsers()
	{
		
		return ResponseEntity.ok().body(userService.getUsers());
		
	}

	@GetMapping("users/active")
	public ResponseEntity<List<UserEntity>> getActiveUser()
	{
		
		return ResponseEntity.ok().body(userService.getActivteUsers('Y'));
		
	}
	
	@GetMapping("users/email/{email}")
	public ResponseEntity<List<UserEntity>> getUsersByEmail(@PathVariable("email") String email)
	{
		
		return ResponseEntity.ok().body(userService.getUsersByEmail(email));
		
	}
	@PostMapping("/user/{firstName}/{lastName}/{email}/{password}/{address}/{phoneNo}/{createdBy}/{roleName}")
	public void addUser(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName,
			@PathVariable("email") String email,@PathVariable("password") String password,
			@PathVariable("address") String address,@PathVariable("phoneNo") String phoneNo,
			@PathVariable("createdBy") String createdBy,@PathVariable("roleName") String roleName)
	{
		UserEntity localUserEntity = new UserEntity();
		
		localUserEntity.setFirstName(firstName);
		localUserEntity.setLastName(lastName);
		localUserEntity.setEmail(email);
		localUserEntity.setPassword(password);
		localUserEntity.setAddress(address);
		localUserEntity.setPhoneNo(phoneNo);
		localUserEntity.setCreatedBy(createdBy);
		
		userService.addUser(localUserEntity,roleName);
		
	}
	
	@PostMapping("/user/{roleName}")
	public void addUser(@RequestBody UserEntity userEntity, 
			@PathVariable("roleName") String roleName) 
	{
		userService.addUser(userEntity, roleName);
	}
	
	@PostMapping("/user")
	public void addUsers(@RequestBody UserEntity userEntity, 
			@RequestParam("roleName") String roleName) 
	{
		userService.addUser(userEntity, roleName);
	}
	
	@PutMapping("/user")
	public void updateUser(@RequestParam("firstName") String firstName,@RequestParam("address") String address)
	{
		userService.updateUser(firstName,address);
		
	}
	
	@PutMapping("/user/inactive")
	public void inActiveUser(@RequestParam("firstName") String firstName)
	{
		userService.inActiveUser(firstName);
		
	}
}
