package com.usermanager.service;

import java.util.List;

import com.usermanager.entity.UsersEntity;

public interface UsersServiceInterface {
	public List<UsersEntity> getAllUser();
	public UsersEntity getUserActive(String isActive);
	public UsersEntity getUserByRole(Integer roleId);

}
