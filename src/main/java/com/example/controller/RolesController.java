package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
} 
