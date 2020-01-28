package com.example.services;

import java.util.List;

import com.example.entities.RoleEntity;

public interface RolesService
{
	public List<RoleEntity> getRoles();

	public RoleEntity getRoleByName(String roleName);

	public void addRole(String roleName);

}
