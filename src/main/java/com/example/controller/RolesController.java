package com.example.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.RoleEntity;
import com.example.services.RolesService;

@RestController
@RequestMapping("role")
public class RolesController 
{
	@Autowired
	private RolesService rolesSerice;
	
	@GetMapping("/roles")
	public List<RoleEntity> getRoles()
	{
		return rolesSerice.getRoles();	
	}
	
	@GetMapping("/roleByName/{roleName}")
	public RoleEntity getRole(@PathVariable("roleName") String roleName) 
	{
		return rolesSerice.getRoleByName(roleName);
	}
} 

