package com.cg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Testclass;
import com.cg.bean.Users;
import com.cg.dao.AdminRepository;
import com.cg.dao.AppointmentRepository;
import com.cg.dao.Diagnostic_centerRepository;
import com.cg.dao.TestclassRepository;
import com.cg.dao.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService
{ 
	@Autowired
    private AdminRepository ar;
	@Autowired
    private UserRepository ur; 
	@Autowired
    private Diagnostic_centerRepository dr;
	@Autowired
    private TestclassRepository tr; 
	@Autowired
    private AppointmentRepository ap;
	
	
	/*
     @Override
     public Users viewUser(int userid)
     {
    	 return ur.findById(userid).get();
     }
    

     @Override
     public List<Users> viewUser()
     {
    	 return udao.findAll();
     }
    */
    
    
     @Override
     public Users addUser(Users user)
     {
    	 return ur.save(user);
     }
     
    
    
     @Override
     public Users updateUser(Users u)
     {
    		Users ud=ur.findById(u.getUserid()).get();
    		if(ud!=null)
    		{
    			ud.setName(u.getName());
    			ud.setPassword(u.getPassword());
    			ud.setPhonenumber(u.getPhonenumber());
    			ud.setEmail(u.getEmail());
    			ud.setGender(u.getGender());
    			ud.setAge(u.getAge());
    		}
    		return ur.save(ud);
    	 
     }
     
   
    
     @Override
     public void deleteUser(int userid)
     {
    	  ur.deleteById(userid);
     }
	  
	@Override
	public Users validate(String uname, String pwd) {
		return ur.validate(uname, pwd);
	}



	@Override
	public List<Testclass> viewTestclass(int centrenum) {
		return tr.findAllById(centrenum);
	}
   
	
	@Override
	public List<Appointment> viewAppointment(int usersid)
     {
    	 return ap.findAllById(usersid);
     }
     
	
	@Override
	public Appointment addAppointment(Appointment appointment)
     {
    	 return ap.save(appointment);
     }
     
	 @Override
     public List<Diagnostic_center> viewDiagnostic_centers()
     {
    	 return dr.findAll();
     }

}
