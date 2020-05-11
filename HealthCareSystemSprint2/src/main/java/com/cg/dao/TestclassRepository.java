package com.cg.dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bean.Appointment;
import com.cg.bean.Testclass;



public interface TestclassRepository extends JpaRepository<Testclass,Serializable>
{
	@Query("select t from Testclass t where t.centrenum=?1")
	List<Testclass> findAllById(int centreid);

	@Query("select t from Testclass t")
	List<Testclass> viewTest();

}