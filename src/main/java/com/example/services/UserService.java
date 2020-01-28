package com.example.services;

import java.util.List;

import com.example.entities.UserEntity;

public interface UserService 
{
	public UserEntity addUser(UserEntity userEntity,String rolename);

	public List<UserEntity> getUsers();

	public List<UserEntity> getActivteUsers(Character isActive);

	public List<UserEntity> getUsersByEmail(String email);

	public UserEntity updateUser(String firstName, String address);

	public UserEntity inActiveUser(String firstName);
}
