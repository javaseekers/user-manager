package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entities.RoleEntity;
import com.example.repostorie.RolesRepository;
	
@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository rolesRepo;
	
	public List<RoleEntity> getRoles() {

		return rolesRepo.findAll();
	}

	@Override
	public RoleEntity getRoleByName(String rolename) 
	{
		return rolesRepo.getByRoleName(rolename);
	}

}
