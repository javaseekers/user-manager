package com.example.repostorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.RoleEntity;

@Repository
public interface RolesRepository extends JpaRepository<RoleEntity, Integer>
{
	public RoleEntity getByRoleName(String rolename);
}
