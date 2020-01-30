package com.example.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.entities.RoleEntity;
import com.example.entities.UserEntity;
import com.example.repositories.RolesRepository;
import com.example.repositories.UserRepository;

@Service
public class UserServiceImpl
{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RolesRepository rolesRepo;

	public UserEntity registerUser(UserEntity userEntity)
	{
		RoleEntity roleEntity = null;

		userEntity.setCreatedBy("admin");
		userEntity.setCreatedDate(new Date());

		userEntity.setIsActive(true);

		roleEntity = rolesRepo.getByRoleName("STUDENT");

		userEntity.setRoleEntity(roleEntity);

		return userRepository.save(userEntity);

	}
	public List<UserEntity> getUsers()
	{
		return userRepository.findAll();
	}
	public List<UserEntity> getActivteUsers()
	{
		return userRepository.getByIsActive(true);
	}
	public UserEntity getUserByEmail(String email)
	{
		return userRepository.getByEmail(email);
	}

	public UserEntity updateUser(UserDto newUserDto)
	{
		UserEntity dbUserEntity = userRepository
			.getByEmail(newUserDto.getEmail());
		
		BeanUtils.copyProperties(newUserDto, dbUserEntity);
		
		dbUserEntity.setUpdatedBy("ADMIN");

		dbUserEntity.setUpdatedDate(new Date());

		return userRepository.save(dbUserEntity);
	}

	public void deleteUser(String email)
	{
		UserEntity userEntity = userRepository.getByEmail(email);

		userEntity.setIsActive(false);

		userRepository.save(userEntity);
	}
}