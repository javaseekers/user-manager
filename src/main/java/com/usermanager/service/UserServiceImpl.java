package com.usermanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanager.entity.UsersEntity;
import com.usermanager.repository.UsersRepository;
@Service
public class UserServiceImpl implements UsersServiceInterface {
	@Autowired
	UsersRepository userReposp;

	@Override
	public List<UsersEntity> getAllUser() {
		return userReposp.findAll();
	}

	@Override
	public UsersEntity getUserActive(String isActive) {
		return userReposp.getByIsActive(isActive);
	}

	@Override
	public UsersEntity getUserByRole(Integer roleId) {
		return userReposp.getUserByRole(roleId);
	}

}
