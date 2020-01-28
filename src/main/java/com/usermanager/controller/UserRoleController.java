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

import com.usermanager.entity.RoleEntity;
import com.usermanager.entity.UsersEntity;
import com.usermanager.service.RoleServiceInterface;
import com.usermanager.service.UsersServiceInterface;

@RestController
@RequestMapping("roleapi")
public class UserRoleController {
	@Autowired
	RoleServiceInterface roleService;
	@Autowired
	UsersServiceInterface userService;

	@GetMapping("/rolem")
	public String getRole() {
		return "hi";
	}

	@GetMapping("/rolelist")
	public ResponseEntity<List<RoleEntity>> getRoleList() {
		List<RoleEntity> localListOfRoles = null;

		localListOfRoles = roleService.getRoles();

		return ResponseEntity.ok().body(localListOfRoles);
	}

	@GetMapping("/roleName/{roleName}")
	public ResponseEntity<RoleEntity> getRoleByName(@PathVariable String roleName) {
		RoleEntity localEntity = null;
		localEntity = roleService.getRoleName(roleName);

		return ResponseEntity.ok().body(localEntity);
	}

	@GetMapping("/userlist")
	public ResponseEntity<List<UsersEntity>> getUserList() {
		List<UsersEntity> localListOfUsers = null;
		localListOfUsers = userService.getAllUser();
		return ResponseEntity.ok().body(localListOfUsers);
	}

	@GetMapping("/userActive/{userActive}")
	public ResponseEntity<UsersEntity> getActiveUsers(@PathVariable String userActive) {
		UsersEntity localEntity = null;
		localEntity = userService.getUserActive(userActive);
		return ResponseEntity.ok().body(localEntity);
	}

	@PostMapping("/adduser/{firstName}/{lastName}/{email}/{password}/{address}/{phone}/{createdBy}/{roleName}")
	public void addUsers(@PathVariable String firstName, @PathVariable String lastName,
			@PathVariable String email, @PathVariable String password, @PathVariable String address,
			@PathVariable String phone, @PathVariable String createdBy, @PathVariable String roleName) 
	{
		UsersEntity localUser = new UsersEntity();
		//localUser.setUserId(userId);
		localUser.setFirstName(firstName);
		localUser.setLastName(lastName);
		localUser.setEmail(email);
		localUser.setPassword(password);
		localUser.setAddress(address);
		localUser.setMobile(phone);
		localUser.setCreatedBy(createdBy);
		localUser.setRoleEntity(roleService.getRoleName(roleName));
		userService.addUsers(localUser);
	}
	@PostMapping("/adduserBody/{roleName}")
	public void addUserBody(@RequestBody UsersEntity localUser, @PathVariable String roleName) 
	{
		localUser.setRoleEntity(roleService.getRoleName(roleName));
		System.out.println("*************************************   "+roleService.getRoleName(roleName));
		userService.addUsers(localUser);
	}
	
	@PostMapping("/updateUser/{phone}/{firstName}")
	public void updatePhone(@PathVariable String phone,@PathVariable String firstName) 
	{
		userService.updateUserPhone(phone, firstName);
	}
	
	@PostMapping("/updateUseractive/{firstName}")
	public void updatePhone(@PathVariable String firstName) 
	{
		userService.userUpdateActive(firstName);
	}


}
