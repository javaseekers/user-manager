package com.usermanager.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanager.entity.UsersEntity;
import com.usermanager.exceptions.ResourceNotFoundException;
import com.usermanager.repository.RolesRepository;
import com.usermanager.repository.UsersRepository;
@Service
public class UserServiceImpl{
	@Autowired
	UsersRepository userReposp;
	
	@Autowired
	RolesRepository rolesRepository;

	public List<UsersEntity> getAllUser() {
		return userReposp.findAll();
	}

	public UsersEntity getByEmail(String email) throws ResourceNotFoundException {
		
		UsersEntity usersEntity=userReposp.getUserByEmail(email);
			
	     	if(usersEntity == null) 
	     	{
				throw new ResourceNotFoundException("No User Found with this mail:"+email);
	     	}
	     	return usersEntity;
		
	}

	public void addUsers(UsersEntity localUser) throws ResourceNotFoundException {
		localUser.setActive(true);
		localUser.setCreatedBy("admin");
		localUser.setCreatedate(new Date());
		userReposp.save(localUser);
	}
	
	public void updateUser(UsersEntity updatedUser, String email) throws ResourceNotFoundException {
		UsersEntity localDbUsers = userReposp.getUserByEmail(email);
		if (localDbUsers == null) {
			throw new ResourceNotFoundException("No User Found with this mail:" + email);
		}
		BeanUtils.copyProperties(updatedUser, localDbUsers);
		localDbUsers.setUpdateBy("admin");
		localDbUsers.setUpdatedate(new Date());
		userReposp.save(localDbUsers);
	}

	public void deleteUser(String email) throws ResourceNotFoundException {
		UsersEntity UsersEntity = userReposp.getUserByEmail(email);
		if (UsersEntity == null) {
			throw new ResourceNotFoundException("No User Found with this mail:" + email);
		}
		UsersEntity.setActive(false);
		userReposp.save(UsersEntity);

	}
}
