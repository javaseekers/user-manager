package com.usermanager.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public UsersEntity getUserByName(String isActive) {
		return userReposp.getByEmail(isActive);
	}

	@Override
	public void addUsers(UsersEntity localUser) 
	{
		localUser.setActive(true);
		localUser.setCreatedate(new Date());
		
		userReposp.save(localUser);	
	}

	@Transactional
	public void updateUserPhone(String phone, String firstName)
	{
		System.out.println("test");
		userReposp.userUpdateByName(phone, firstName);
	}

	@Override
	public void userUpdateEmail(String email) {
		UsersEntity UsersEntity=userReposp.getUserByEmail(email);
		UsersEntity.setActive(false);
		userReposp.save(UsersEntity);
		
	}

}
