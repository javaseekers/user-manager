package com.example.services;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public UserEntity updateUser(UserEntity newUserEntity)
	{
		UserEntity oldUserEntity = userRepository
			.getByEmail(newUserEntity.getEmail());

		newUserEntity = updateNotNullUserInfoToUserEntity(oldUserEntity,
			newUserEntity);

		return userRepository.save(newUserEntity);
	}

	public void deleteUser(String email)
	{
		UserEntity userEntity = userRepository.getByEmail(email);

		userEntity.setIsActive(false);

		userRepository.save(userEntity);
	}

	private UserEntity updateNotNullUserInfoToUserEntity(
		UserEntity oldUserEntity, UserEntity newUserEntity)
	{
		String firstName;
		String lastName;
		String password;
		String address;
		String phoneNo;

		firstName = newUserEntity.getFirstName();

		firstName = Objects.toString(firstName, "");

		lastName = newUserEntity.getLastName();

		lastName = Objects.toString(lastName, "");

		password = newUserEntity.getPassword();

		password = Objects.toString(password, "");

		address = newUserEntity.getAddress();

		address = Objects.toString(address, "");

		phoneNo = newUserEntity.getPhoneNo();
		phoneNo = Objects.toString(phoneNo, "");

		if (firstName.length() > 0)
		{
			oldUserEntity.setFirstName(firstName);
		}
		if (lastName.length() > 0)
		{
			oldUserEntity.setLastName(lastName);
		}
		if (password.length() > 0)
		{
			oldUserEntity.setPassword(password);
		}
		if (address.length() > 0)
		{
			oldUserEntity.setAddress(address);
		}
		if (phoneNo.length() > 0)
		{
			oldUserEntity.setPhoneNo(phoneNo);
		}
		return oldUserEntity;
	}

}