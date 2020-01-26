package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.RoleEntity;
import com.example.services.RolesService;

@RestController
@RequestMapping("rolesApi")
public class RolesController {
	@Autowired
	private RolesService rolesSerice;

	@GetMapping("/roles")
	public ResponseEntity<List<RoleEntity>> getRoles() 
	{
		List<RoleEntity> 	localListOfRoles = null;
		
		ResponseEntity<List<RoleEntity>> localResponseEntiy = null;
		
		localListOfRoles = rolesSerice.getRoles();
		
		localResponseEntiy = new ResponseEntity<List<RoleEntity>>(localListOfRoles, HttpStatus.FOUND);
		
		return localResponseEntiy;
	}

	@GetMapping("/roleByName/{roleName}")
	public ResponseEntity<RoleEntity> getRole(@PathVariable("roleName") String roleName)
	{
		RoleEntity 	localRoleEntity = null;
		
		ResponseEntity<RoleEntity> localResponseEntiy = null;
		
		localRoleEntity = rolesSerice.getRoleByName(roleName);
		
		localResponseEntiy = new ResponseEntity<RoleEntity>(localRoleEntity, HttpStatus.FOUND);
		
		return localResponseEntiy;
	}
}
