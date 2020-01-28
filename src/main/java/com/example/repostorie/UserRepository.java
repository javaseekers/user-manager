package com.example.repostorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>
{

	public List<UserEntity> getByIsActive(Character isActive);

	public UserEntity getByEmail(String email);

//	@Modifying
//	@Query(" update UserEntity u set u.address = ?1 where u.firstName = ?2")
//	public void updateUser(String address, String firstName);
//
//	@Modifying
//	@Query(" update UserEntity u set u.isActive = 'N' where u.firstName = :firstName")
//	public void inActiveUser(@Param("firstName") String firstName);

}
