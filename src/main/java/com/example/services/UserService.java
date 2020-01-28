package com.example.services;

import java.util.List;

import com.example.entities.UserEntity;

public interface UserService
{
	public UserEntity registerUser(UserEntity userEntity);

	public List<UserEntity> getUsers();

	public List<UserEntity> getActivteUsers();

	public UserEntity getUserByEmail(String email);

	public UserEntity updateUser(UserEntity userEntity);
	
	public void deleteUser(String email);
}
