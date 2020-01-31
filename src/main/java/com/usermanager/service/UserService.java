package com.usermanager.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usermanager.entity.RoleEntity;
import com.usermanager.entity.UsersEntity;
import com.usermanager.repository.RolesRepository;
import com.usermanager.repository.UsersRepository;

@Service
public class UserService {
	@Autowired
	UsersRepository userReposp;

	@Autowired
	RolesRepository rolesRepository;

	public List<UsersEntity> getUsers() {
		return userReposp.findAll();
	}

	public UsersEntity getActiveUsers() {
		return userReposp.getByIsActive(true);
	}

	public void addUser(UsersEntity user) {
		user.setActive(true);
		user.setCreatedBy("admin");
		user.setCreatedate(new Date());
		RoleEntity role = rolesRepository.getByRoleName("examinee");
		user.setRoleEntity(role);
		userReposp.save(user);
	}

	public void updateUser(UsersEntity updatedUser, String email) {

		UsersEntity persistedUser = userReposp.getByEmail(email);
		BeanUtils.copyProperties(updatedUser, persistedUser);
		persistedUser.setUpdateBy("admin");
		persistedUser.setUpdatedate(new Date());
		userReposp.save(persistedUser);
	}

	public void deleteUser(String email) {
		UsersEntity UsersEntity = userReposp.getUserByEmail(email);
		UsersEntity.setActive(false);
		userReposp.save(UsersEntity);

	}

}
