package com.example.repostorie;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
public class UserRepositoryImpl  
{

	@Modifying
	@Query("update UserEntity u set u.address = ?1 where u.firstName = ?2")
	public void updateUser(String firstName, String address) 
	{
		
	}
	
	

}
