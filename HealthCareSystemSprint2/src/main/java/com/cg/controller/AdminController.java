package com.cg.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bean.Admins;
import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Testclass;
import com.cg.exceptions.UserNotFoundException;
import com.cg.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")

public class AdminController {
	 
	 @Autowired
     private AdminService adminservice;
	 
	    
     @GetMapping("/valid/{adminname}/{adminpassword}")
 	public ResponseEntity<Admins> validate(@PathVariable("adminname") String aname, @PathVariable("adminpassword") String apwd) throws UserNotFoundException{
 		Admins a= adminservice.validate(aname, apwd);
 		ResponseEntity<Admins> res = new ResponseEntity<Admins>(a,HttpStatus.OK);
 		return res;
 	}
     
	 
	 @PutMapping("/approveAppointment")
     public Appointment updateAppoinment(@RequestBody Appointment appointment)
     {
    	 return adminservice.updateAppointment(appointment);
     }
	 
	
	         
	     @GetMapping(value="/getAllAppointments")
	     public List<Appointment> viewAppointment2()
	     {
	    	 return adminservice.viewAppointment2();
	     }
	         
	     
	     
	     
		     @PostMapping(value="/addCenter")
		     public String addCenter(@RequestBody()Diagnostic_center center)
		     {
		    	 adminservice.addCenter(center);
		    	 return "Center added";	 
		     }
		     
		     @GetMapping(value="/getAllCenters")
		     public List<Diagnostic_center> viewDiagnostic_center()
		     {
		    	 return adminservice.viewDiagnostic_center();
		     }
		  
		     
		     @DeleteMapping("/removeCenter/{centreid}")
		     public String removeDiagnostic_center(@PathVariable int centreid)
		     {
		    	 adminservice.removeCenter(centreid);
		    	 return "Diagnostic_center Details Removed";
		     }
		     
		     /*
			     @PostMapping(value="/addTest/{centreid}")
			     public String addTest(@PathVariable int centreid,@RequestBody()Testclass test)
			     {
			    	 adminservice.addTest(centreid);
			    	 return "Testclass added";	 
			     }
			    */ 
			     
			     @PostMapping(value="/addTest")
			     public String addTestclass(@RequestBody()Testclass testclass)
			     {
			    	 adminservice.addTestclass(testclass);
			    	 return "Testclass added";	 
			     }
			     
			     
			     @GetMapping(value="/getAllTests")
			     public List<Testclass> viewTestclass()
			     {
			    	 return adminservice.viewTestclass();
			     }
			     
			     
			     @DeleteMapping("/removeTest/{testid}")
			     public String removeTestclass(@PathVariable int testid)
			     {
			    	 adminservice.removeTestclass(testid);
			    	 return "Testclass Details Removed";
			     }
			     
			 
} 


