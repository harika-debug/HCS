package com.cg.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Testclass;
import com.cg.bean.Users;
import com.cg.dao.AppointmentRepository;
import com.cg.dao.UserRepository;

public interface UserService {
	
	Users validate(String uname, String pwd);
	//Users viewUser(int userid);

	//List<Users> viewUser();
	List<Testclass> viewTestclass(int centrenum);

	Users addUser(Users user);
	Users updateUser(Users user);
	void deleteUser(int userid);

	Appointment addAppointment(Appointment appointment);
	List<Appointment> viewAppointment(int usersid);

	List<Diagnostic_center> viewDiagnostic_centers();


	

}