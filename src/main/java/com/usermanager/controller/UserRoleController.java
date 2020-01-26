package com.usermanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/userrole/{userRoleId}")
	public ResponseEntity<UsersEntity> getUsersByrole(@PathVariable Integer userRoleId) {
		UsersEntity localEntity = null;
		localEntity = userService.getUserByRole(userRoleId);
		return ResponseEntity.ok().body(localEntity);
	}


}
