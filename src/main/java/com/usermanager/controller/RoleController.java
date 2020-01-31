package com.usermanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usermanager.entity.RoleEntity;
import com.usermanager.service.RoleService;

@RestController
@RequestMapping("/api/v1")
public class RoleController {
	@Autowired
	RoleService roleService;

	@GetMapping("/roles")
	public ResponseEntity<List<RoleEntity>> getRoleList() {

		List<RoleEntity> localListOfRoles = roleService.getRoles();

		return ResponseEntity.ok().body(localListOfRoles);
	}

	@GetMapping("/role/{name}")
	public ResponseEntity<RoleEntity> getRoleByName(@PathVariable String name) {

		RoleEntity localEntity = roleService.getRoleName(name);

		return ResponseEntity.ok().body(localEntity);
	}
}
