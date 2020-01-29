package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
	public List<UserEntity> getByIsActive(Boolean isActive);

	public UserEntity getByEmail(String email);
}
