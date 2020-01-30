package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.entities.UserEntity;
import com.example.services.UserServiceImpl;

@RestController
@RequestMapping("userApi")
public class UserController
{
	@Autowired
	private UserServiceImpl userService;

	@GetMapping("users")
	public ResponseEntity<List<UserEntity>> getUsers()
	{
		return ResponseEntity.ok().body(userService.getUsers());
	}
	@GetMapping("activeUsers")
	public ResponseEntity<List<UserEntity>> getActiveUser()
	{
		return ResponseEntity.ok().body(userService.getActivteUsers());
	}
	@GetMapping("users/{email}")
	public ResponseEntity<UserEntity> getUserByEmail(
		@PathVariable("email") String email)
	{
		return ResponseEntity.ok().body(userService.getUserByEmail(email));
	}

	@PostMapping("/users")
	public ResponseEntity<String> registerUser(
		@RequestBody UserEntity userEntity)
	{
		userService.registerUser(userEntity);
		return ResponseEntity.ok().body("User Registered Sucessfully");

	}
	@PutMapping("/users")
	public ResponseEntity<String> updateUser(
		@RequestBody UserDto userEntity)
	{
		userService.updateUser(userEntity);

		return ResponseEntity.ok().body("User updated successfully");
	}

	@DeleteMapping("/users/{email}")
	public ResponseEntity<String> deleteUser(
		@PathVariable("email") String email)
	{
		userService.deleteUser(email);
		return ResponseEntity.ok().body("User Deleted sucessfully");
	}
}
