package com.cg.sprint.service;


import static org.junit.Assert.assertEquals;
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
import com.cg.bean.Testclass;
import com.cg.dao.AdminRepository;
import com.cg.dao.AppointmentRepository;
import com.cg.dao.Diagnostic_centerRepository;
import com.cg.dao.TestclassRepository;
import com.cg.service.AdminServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
public class AdminServiceTests {
	@Mock
	private AdminRepository ar;
	@Mock
	private Diagnostic_centerRepository cr;
	@Mock
	private TestclassRepository tr;
	@Mock
	private AppointmentRepository ap;
	
	
	
	@InjectMocks
	private AdminServiceImpl adminService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testviewDiagnostic_center(){
		List<Diagnostic_center> centerList = new ArrayList<Diagnostic_center>();
		centerList.add(new Diagnostic_center(1,"hyderabad",1234567890L,"nacharam"));
		centerList.add(new Diagnostic_center(2,"secunderabad",9999999990L,"prakashnagar"));
		centerList.add(new Diagnostic_center( 3,"nagole",1234567834L,"suryanagar"));
		when(cr.findAll()).thenReturn(centerList);
		List<Diagnostic_center> result = adminService.viewDiagnostic_center();
		assertEquals(3, result.size());
	}
	
	
	
	@Test
	public void addCenter(){
		Diagnostic_center center = new Diagnostic_center(4,"ameerpet",1234567880L,"punjagutta" );
		adminService.addCenter(center);
		Mockito.verify(cr,Mockito.times(1)).save(center);
	}
		
	
	
	@Test
	public void removeCenter(){
		Diagnostic_center centreid = new Diagnostic_center(4,"ameerpet",1235467890L,"punjagutta");
		adminService.removeCenter(centreid.getCentreid());
        verify(cr,times(1)).deleteById(centreid.getCentreid());
	}
	/*cr.deleteById(4);
		cr.save(centreid);
		verify(cr,Mockito.times(1)).save(centreid);
	}*/
	
	
	@Test
	public void testviewTestClass(){
		List<Testclass> testList = new ArrayList<Testclass>();
		testList.add(new Testclass(1,"bloodtest",12));
		testList.add(new Testclass(2,"bp",13));
		testList.add(new Testclass(3,"sugar",14));
		when(tr.findAll()).thenReturn(testList);
		
		List<Testclass> result = adminService.viewTestclass();
		assertEquals(3, result.size());
	}
	
	
	
	
	@Test
	public void addTestclass(){
		Testclass testclass = new Testclass(4,"dengue",15);
		adminService.addTestclass(testclass);
		verify(tr,times(1)).save(testclass);
	}

	@Test
	public void removeTestclass(){
		Testclass testid = new Testclass(4,"dengue",15);
		adminService.removeTestclass(testid.getTestid());
        verify(tr, times(1)).deleteById(testid.getTestid());
	}
	
	

	
	@Test
	public void testviewAppointment2() throws java.text.ParseException{
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyy-MM-dd");
		Date d1 = sdf1.parse("2020-04-04");
		appointmentList.add(new Appointment(1,"Appointment Status1",sdf1,12,"bloodtest",2));
		
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyy-MM-dd");
		Date d2 = sdf2.parse("2020-04-05");
		appointmentList.add(new Appointment(2,"Appointment Status2",sdf2,13,"bp",3));
		
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyy-MM-dd");
		Date d3 = sdf3.parse("2020-04-06");
		appointmentList.add(new Appointment(3,"Appointment Status3",sdf3,14,"sugar",4));
		when(ap.findAll()).thenReturn(appointmentList);
		
		List<Appointment> result = adminService.viewAppointment2();
		assertEquals(3, result.size());
	}
	
	@Test
	public void updateAppointment() throws java.text.ParseException{
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyy-MM-dd");
		Date d4= sdf4.parse("2020-04-07");
		Appointment a = new Appointment(4,"Appointment Status4",sdf4,15,"tt",5);
		//ap.findById(4);
		ap.save(a);
		verify(ap,Mockito.times(1)).save(a);
	}

}

	