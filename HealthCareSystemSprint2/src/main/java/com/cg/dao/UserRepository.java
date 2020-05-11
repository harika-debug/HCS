package com.cg.dao;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bean.Users;



public interface UserRepository extends JpaRepository<Users,Serializable>
{

	@Query("select a from Users a where name=?1 and password=?2 ")
	public Users validate(String uname, String pwd);
	
}