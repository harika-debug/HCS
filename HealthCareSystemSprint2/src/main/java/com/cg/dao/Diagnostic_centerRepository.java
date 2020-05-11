package com.cg.dao;


import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;



public interface Diagnostic_centerRepository extends JpaRepository<Diagnostic_center,Integer>
{
	@Query("select d from Diagnostic_center d")
	List<Diagnostic_center> viewDiagnostic_center();
	
	@Query("select d from Diagnostic_center d")
	List<Diagnostic_center> viewDiagnostic_centers();

}