package com.example.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.RoleEntity;
import com.example.entities.UserEntity;
import com.example.repostorie.RolesRepository;
import com.example.repostorie.UserRepository;

@Service
public class UserEntityImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RolesRepository rolesRepo;
	public UserEntity addUser(UserEntity userEntity, String rolename)
	{
		RoleEntity roleEntity=null;
		userEntity.setCreatedDate(new Date());
		
		roleEntity=rolesRepo.getByRoleName(rolename);
		if (roleEntity == null)
		{
			
		}
		else
		{
			userEntity.setRoleEntity(roleEntity);
		}
		return userRepository.save(userEntity);

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
	public List<UserEntity> getUsersByEmail(String email)
	{
		// TODO Auto-generated method stub
		return userRepository.getByEmail(email);
	}

	@Transactional
	public UserEntity updateUser(String firstName, String address)
	{
		return userRepository.updateUser(address, firstName);
	}
	@Transactional
	public UserEntity inActiveUser(String firstName)
	{
		return userRepository.inActiveUser(firstName);
	}

}
