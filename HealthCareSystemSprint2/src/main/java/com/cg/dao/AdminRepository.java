package com.cg.dao;



import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bean.Admins;



public interface AdminRepository extends JpaRepository<Admins,Integer>
{

	
	@Query("select a from Admins a where adminname=?1 and adminpassword=?2 ")
	Admins validate(String aname, String apwd);

}