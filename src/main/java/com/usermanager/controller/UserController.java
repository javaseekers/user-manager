package com.usermanager.controller;

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

import com.usermanager.entity.UsersEntity;
import com.usermanager.service.RoleService;
import com.usermanager.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	RoleService roleService;
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<UsersEntity>> getUsers() {

		List<UsersEntity> localListOfUsers = userService.getUsers();
		return ResponseEntity.ok().body(localListOfUsers);
	}

	@GetMapping("/user/active-users")
	public ResponseEntity<UsersEntity> getActiveUsers() {

		UsersEntity localEntity = userService.getActiveUsers();
		return ResponseEntity.ok().body(localEntity);
	}

	@PostMapping("/users")
	public void addUser(@RequestBody UsersEntity user) {
		userService.addUser(user);
	}

	@PutMapping("/users/{email}")
	public void updateUser(@RequestBody UsersEntity updatedUser, @PathVariable String email) {
		userService.updateUser(updatedUser, email);
	}

	@DeleteMapping("/users/{email}")
	public void deleteUser(@PathVariable String email) {
		userService.deleteUser(email);
	}
}
