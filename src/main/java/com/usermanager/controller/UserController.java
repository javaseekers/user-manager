package com.usermanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanager.entity.UsersEntity;
import com.usermanager.exceptions.ResourceNotFoundException;
import com.usermanager.service.RoleServiceImpl;
import com.usermanager.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	@Autowired
	RoleServiceImpl roleService;
	@Autowired
	UserServiceImpl userService;

	@GetMapping("/users")
	public ResponseEntity<List<UsersEntity>> getUsers() {
		List<UsersEntity> localListOfUsers = null;
		localListOfUsers = userService.getAllUser();
		return ResponseEntity.ok().body(localListOfUsers);
	}

	@GetMapping("/userByEmail/{email}")
	public ResponseEntity<UsersEntity> getUserByEmail(@PathVariable String email) throws ResourceNotFoundException {
		UsersEntity localEntity = userService.getByEmail(email);
		return ResponseEntity.ok().body(localEntity);
	}

	@PostMapping("/user/{roleName}")
	public void addUser(@RequestBody UsersEntity localUser, @PathVariable String roleName)
			throws ResourceNotFoundException {
		localUser.setRoleEntity(roleService.getRoleName(roleName));
		userService.addUsers(localUser);
	}

	@PutMapping("/users/{email}")
	public void updateUser(@RequestBody UsersEntity updatedUser, @PathVariable String email)
			throws ResourceNotFoundException {
		userService.updateUser(updatedUser, email);
	}

	@PostMapping("/users/{email}")
	public void deleteUser(@PathVariable String email) throws ResourceNotFoundException {
		userService.deleteUser(email);
	}
}
