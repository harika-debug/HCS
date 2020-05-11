package com.cg.sprint.service;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.bean.Appointment;
import com.cg.bean.Diagnostic_center;
import com.cg.bean.Users;
import com.cg.bean.Testclass;
import com.cg.dao.AppointmentRepository;
import com.cg.dao.Diagnostic_centerRepository;
import com.cg.dao.TestclassRepository;
import com.cg.dao.UserRepository;
import com.cg.service.UserServiceImpl;

import net.minidev.json.parser.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTests {
	
	@Mock
	private UserRepository ur;
	@Mock
	private Diagnostic_centerRepository cr;
	@Mock
	private TestclassRepository tr;
	@Mock
	private AppointmentRepository ap;
	
	
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testviewTestclass(){
		List<Testclass> testList = new ArrayList<Testclass>();
		testList.add(new Testclass(1,"bloodtest",12));
		testList.add(new Testclass(2,"bp",13));
		testList.add(new Testclass(3,"sugar",14));
		when(tr.findAll()).thenReturn(testList);
		
		//List<Testclass> result = userService.viewTestclass();
		//assertEquals(3, result.size());
	}
	
	
	
	
	@Test
	public void addUser(){
		Users user = new Users(1,"monika",20,"female",9000000000L,"abcde","moni@gmail.com");
		userService.addUser(user);
		Mockito.verify(ur,Mockito.times(1)).save(user);
	}
		
	
	
	
	@Test
	public void updateUser(){
		Users user = new Users(2,"manish",21,"male",9000000010L,"abe","mani@gmail.com");
		//ur.findById(1);
		ur.save(user);
        verify(ur,Mockito. times(1)).save(user);
	}
	

		
	@Test
	public void deleteUser(){
	   Users  userid = new Users(4,"mohit",20,"male",9100000000L,"abcdef","mohi@gmail.com");
	   userService.deleteUser(userid.getUserid());
	   verify(ur,times(1)).deleteById(userid.getUserid());
	}
	/*ur.deleteById(4);
	  verify(ur,times(1)).deleteById(4);
	}*/
	

	
	
	@Test
	public void addAppointment() throws java.text.ParseException{
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd");
		Date d = sdf1.parse("2020-04-03");
		Appointment appointment = new Appointment(4,"Appointment Status",sdf1,15,"sugar",2 );
		userService.addAppointment(appointment);
		Mockito.verify(ap,Mockito.times(1)).save(appointment);
	}
		
	
	
	
	@Test
	public void viewAppointment() throws java.text.ParseException{
		SimpleDateFormat sdf= new SimpleDateFormat("yyy-MM-dd");
			Date d1 = sdf.parse("2020-04-01");
			
	    Appointment appointmentid = new Appointment(1,"Appointment Status",sdf,12,"bp",3);
	    
	    //ap.findById(1);
	    ap.save(appointmentid);
	    verify(ap,Mockito.times(1)).save(appointmentid);
	}
	
	
	/*	when(ap.findAll()).thenReturn(appointmentid);
		Appointment result = userService.viewAppointment(1);
		assertEquals(1, result.getAppointmentid());
		assertEquals("Appointment status", result.getAppointmentstatus());
		assertEquals( sdf,result.getDatetime());
		assertEquals(1235467890, result.getCentrenumber());
		assertEquals("bp", result.getTestnames());
	}*/
	
	
	
	
	@Test
	public void testviewDiagnostic_center(){
		List<Diagnostic_center> centerList = new ArrayList<Diagnostic_center>();
		centerList.add(new Diagnostic_center(1,"hyderabad",123456789L,"nacharam"));
		centerList.add(new Diagnostic_center(2,"secunderabad",345678902L,"prakashnagar"));
		centerList.add(new Diagnostic_center( 3,"ameerpet",123456783L,"punjagutta"));
		when(cr.findAll()).thenReturn(centerList);
		
		List<Diagnostic_center> result = userService.viewDiagnostic_centers();
		assertEquals(3, result.size());
	}
}
