package com.usermanager.service;

import java.util.List;

import com.usermanager.entity.UsersEntity;

public interface UsersServiceInterface {
	public List<UsersEntity> getAllUser();
	public UsersEntity getUserActive(String isActive);
	public void addUsers(UsersEntity localEntity);
	public void updateUserPhone(String phone, String firstName);
	public void userUpdateActive(String firstName);

}
