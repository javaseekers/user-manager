package com.usermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usermanager.entity.UsersEntity;
@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
	
	public UsersEntity getByIsActive(String isActive);
	
	@Modifying
	@Query("UPDATE UsersEntity u SET u.mobile = :mobile WHERE u.firstName = :firstName")
	public void userUpdateByName(String mobile, String firstName);
	@Modifying
	@Query("UPDATE UsersEntity u SET u.isActive = 'N' WHERE u.firstName = :firstName")
	public void userUpdateActive(String firstName);
	
	
	}
