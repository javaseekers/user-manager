package com.usermanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanager.entity.RoleEntity;
import com.usermanager.repository.RolesRepository;
@Service
public class RoleServiceImpl implements RoleServiceInterface {
	@Autowired
	RolesRepository roleRepositry;

	@Override
	public List<RoleEntity> getRoles() {	
		return roleRepositry.findAll();
	}

	@Override
	public RoleEntity getRoleName(String roleName) 
	{
		return roleRepositry.getByRoleName(roleName);
	}

}
