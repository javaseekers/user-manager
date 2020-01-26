package com.usermanager.service;

import java.util.List;

import com.usermanager.entity.RoleEntity;

public interface RoleServiceInterface {
public List<RoleEntity> getRoles();
public RoleEntity getRoleName(String roleName);
}
