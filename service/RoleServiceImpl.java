package com.usermanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanager.entity.RoleEntity;
import com.usermanager.exceptions.ResourceNotFoundException;
import com.usermanager.repository.RolesRepository;
@Service
public class RoleServiceImpl {
	@Autowired
	RolesRepository roleRepositry;

	public List<RoleEntity> getRoles() {	
		return roleRepositry.findAll();
	}

	public RoleEntity getRoleName(String roleName) throws ResourceNotFoundException 
	{
		RoleEntity role = roleRepositry.getByRoleName(roleName);
		System.out.println("role   "+role);
		if (role == null) {
			throw new ResourceNotFoundException("No roles found.");
		}
		return role;
	}

}
