package com.usermanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanager.entity.RoleEntity;
import com.usermanager.repository.RolesRepository;

@Service
public class RoleService {
	@Autowired
	RolesRepository roleRepositry;

	public List<RoleEntity> getRoles() {
		return roleRepositry.findAll();
	}

	public RoleEntity getRoleName(String roleName) {
		return roleRepositry.getByRoleName(roleName);
	}

}
