package com.cg.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.bean.Appointment;



public interface AppointmentRepository extends JpaRepository<Appointment,Integer>
{
	
	@Query("select a from Appointment a where a.usersid=?1")
	List<Appointment> findAllById(int usersid);
	@Query("select a from Appointment a")
	List<Appointment> viewAppointment2();

}