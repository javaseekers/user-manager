package com.example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>
{
	public List<UserEntity> getByIsActive(Boolean isActive);

	public Optional<UserEntity> getByEmail(String email);
}
