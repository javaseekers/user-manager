package com.example.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.UserEntity;
import com.example.repostorie.RolesRepository;
import com.example.repostorie.UserRepository;
import com.example.repostorie.UserRepositoryImpl;

@Service
public class UserEntityImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RolesRepository rolesRepo;
	public void addUser(UserEntity userEntity,String rolename) 
	{
		
		userEntity.setCreatedDate(new Date());
		userEntity.setRoleEntity(rolesRepo.getByRoleName(rolename));
		
		userRepository.save(userEntity);
		
	}
	@Override
	public List<UserEntity> getUsers() 
	{
		return userRepository.findAll();
	}
	@Override
	public List<UserEntity> getActivteUsers(Character isActive) 
	{
		return userRepository.getByIsActive(isActive);
	}
	@Override
	public List<UserEntity> getUsersByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.getByEmail(email);
	}

	@Transactional
	public void updateUser(String firstName, String address)
	{
		userRepository.updateUser(address,firstName);
	}
	@Transactional
	public void inActiveUser(String firstName) 
	{
		userRepository.inActiveUser(firstName);
	}

}
