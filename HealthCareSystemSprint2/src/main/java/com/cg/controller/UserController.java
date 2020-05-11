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

import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Testclass;
import com.cg.bean.Users;
import com.cg.exceptions.UserNotFoundException;
import com.cg.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")

public class UserController {
	
	 @Autowired
     private UserService userservice;
	 
	 
	  @GetMapping("/valid/{name}/{password}")
	 	public ResponseEntity<Users> validate(@PathVariable("name") String uname, @PathVariable("password") String pwd) throws UserNotFoundException{
	 		Users us = userservice.validate(uname, pwd);
	 		ResponseEntity<Users> res = new ResponseEntity<Users>(us,HttpStatus.OK);
	 		return res;
	 	}
	     
	
	 
	 @PostMapping(value="/makeAppointment")
     public Appointment addAppointment(@RequestBody()Appointment appointment)
     {
		 return userservice.addAppointment(appointment);
     }
	 
	 @GetMapping(value="/getAppointment/{usersid}")
     public List<Appointment> viewAppointment(@PathVariable("usersid") int usersid)
     {
    	 return userservice.viewAppointment(usersid);
     }
	 
	 
	     @PostMapping(value="/addUser")
	     public Users addUser(@RequestBody()Users user)
	     {
	    	 return userservice.addUser(user);
	    	
	     }
	     
	   
	     
	     
	     @DeleteMapping("/deleteUser/{userid}")
	     public String deleteUser(@PathVariable int userid)
	     {
	    	 userservice.deleteUser(userid);
	    	 return "User Details Deleted";
	     }
	     
	     @PutMapping("/updateUser")
	     public Users updateUser(@RequestBody Users user)
	     {
	    	 return userservice.updateUser(user);
	    	 
	     }
	     
	     @GetMapping(value="/getAllCenters")
	     public List<Diagnostic_center> viewDiagnostic_centers()
	     {
	    	 return userservice.viewDiagnostic_centers();
	     }
	     
	     @GetMapping(value="/getAllTests/{centrenum}")
	     public List<Testclass> viewTestclass(@PathVariable("centrenum") int centrenum)
	     {
	    	 return userservice.viewTestclass(centrenum);
	     }
	     
	          
	     	    
}
