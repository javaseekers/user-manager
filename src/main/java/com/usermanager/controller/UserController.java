package com.usermanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanager.entity.UsersEntity;
import com.usermanager.service.RoleServiceInterface;
import com.usermanager.service.UsersServiceInterface;
@RestController
@RequestMapping("userapi")
public class UserController {
	@Autowired
	RoleServiceInterface roleService;
	@Autowired
	UsersServiceInterface userService;
	@GetMapping("/users")
	public ResponseEntity<List<UsersEntity>> getUserList() {
		List<UsersEntity> localListOfUsers = null;
		localListOfUsers = userService.getAllUser();
		return ResponseEntity.ok().body(localListOfUsers);
	}

	@GetMapping("/user/{userActive}")
	public ResponseEntity<UsersEntity> getActiveUsers(@PathVariable String userActive) {
		UsersEntity localEntity = null;
		localEntity = userService.getUserByName(userActive);
		return ResponseEntity.ok().body(localEntity);
	}
	@PostMapping("/user/{roleName}")
	public void addUserBody(@RequestBody UsersEntity localUser, @PathVariable String roleName) 
	{
		localUser.setRoleEntity(roleService.getRoleName(roleName));
		userService.addUsers(localUser);
	}
	
	@PostMapping("/updateUser/{phone}/{firstName}")
	public void updatePhone(@PathVariable String phone,@PathVariable String firstName) 
	{
		userService.updateUserPhone(phone, firstName);
	}
	
	@PostMapping("/userinactive/{email}")
	public void updateInActive(@PathVariable String email) 
	{
		userService.userUpdateEmail(email);
	}
}
