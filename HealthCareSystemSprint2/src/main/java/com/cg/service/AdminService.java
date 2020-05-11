package com.cg.service;

import java.util.List;

import com.cg.bean.Admins;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Testclass;
import com.cg.dao.AdminRepository;
import com.cg.dao.Diagnostic_centerRepository;
import com.cg.dao.TestclassRepository;


public interface AdminService {
	
	Admins validate(String aname, String apwd);
	
	List<Diagnostic_center> viewDiagnostic_center();
	List<Testclass> viewTestclass();

	Diagnostic_center addCenter(Diagnostic_center center);
	void removeCenter(int centreid);
	Testclass addTestclass(Testclass testclass);
	void removeTestclass(int testid);

	Appointment updateAppointment(Appointment a);
	List<Appointment> viewAppointment2();


	

}