package com.usermanager.service;

import java.util.List;

import com.usermanager.entity.UsersEntity;

public interface UsersServiceInterface {
	public List<UsersEntity> getAllUser();
	public UsersEntity getUserByName(String email);
	public void addUsers(UsersEntity localEntity);
	public void updateUserPhone(String phone, String firstName);
	public void userUpdateEmail(String email);
}
