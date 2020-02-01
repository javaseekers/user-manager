package com.example.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.entities.RoleEntity;
import com.example.entities.UserEntity;
import com.example.exceptions.UserErrorInfo;
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

		getUserByEmail(userEntity.getEmail(), "new");

		userEntity.setCreatedBy("admin");
		userEntity.setCreatedDate(new Date());

		userEntity.setIsActive(true);

		roleEntity = rolesRepo.getByRoleName("STUDENT");

		userEntity.setRoleEntity(roleEntity);

		return userRepository.save(userEntity);

	}
	public List<UserEntity> getUsers()
	{
		List<UserEntity> userList = userRepository.findAll();

		if (userList.isEmpty())
		{
			throw new UserErrorInfo(
				"error.no.users.Exists");
		}

		return userList;
	}
	public List<UserEntity> getActivteUsers()
	{
		List<UserEntity> userList = userRepository.getByIsActive(true);

		if (userList.isEmpty())
		{
			throw new UserErrorInfo(
				"error.no.active.users.Exists");
		}

		return userList;
	}
	public UserEntity getUserByEmail(String email, String newUser)
	{
		Optional<UserEntity> userEntity = null;

		if (email == null || email.length() == 0)
		{
			throw new UserErrorInfo(
				"error.mailid.mandatory");
		}
		else if ("new".equals(newUser))
		{
			userEntity = userRepository.getByEmail(email);
			if (userEntity.isPresent())
			{
				throw new UserErrorInfo(
					"error.mailid.already.exist");
			}

			return null;
		}
		else
		{
			userEntity = userRepository.getByEmail(email);
			return userEntity.orElseThrow(() -> new UserErrorInfo(
				"error.user.not.exist"));
		}

	}

	public UserEntity updateUser(UserDto newUserDto)
	{
		UserEntity dbUserEntity = getUserByEmail(newUserDto.getEmail(), "");

		BeanUtils.copyProperties(newUserDto, dbUserEntity);

		dbUserEntity.setUpdatedBy("ADMIN");

		dbUserEntity.setUpdatedDate(new Date());

		dbUserEntity = userRepository.save(dbUserEntity);

		return dbUserEntity;
	}

	public void deleteUser(String email)
	{
		UserEntity userEntity = getUserByEmail(email, "");

		userEntity.setIsActive(false);

		userRepository.save(userEntity);
	}

}