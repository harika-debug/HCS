package com.cg.bean;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



@Entity
@Table(name = "Appointment")

public class Appointment {
	
	@Id
	@Column(name="appointmentid")
	private int appointmentid;	
	@Column(name="appointmentstatus")
	private String appointmentstatus;
	@Column(name="datetime")
	private SimpleDateFormat datetime;
	@Column(name="centrenumber")
	private int centrenumber;
	@Column(name="testnames")
	private String testnames;
	@Column(name="usersid")
	private int usersid;
	
	
	public Appointment() {}
	
public Appointment(int appointmentid, String appointmentstatus, SimpleDateFormat datetime, int centrenumber, String testnames,int usersid) {
		
		this.appointmentid = appointmentid;
		this.appointmentstatus = appointmentstatus;
		this.datetime = datetime;
		this.centrenumber = centrenumber;
		this.testnames = testnames;
		this.usersid=usersid;
	}
	
	public int getUsersid() {
		return usersid;
	}
	public void setUsersid(int usersid) {
		this.usersid = usersid;
	}
	public String getTestnames() {
		return testnames;
	}
	public void setTestnames(String testnames) {
		this.testnames = testnames;
	}
	public int getCentrenumber() {
		return centrenumber;
	}
	public void setCentrenumber(int centrenumber) {
		this.centrenumber = centrenumber;
	}
	public int getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	public String getAppointmentstatus() {
		return appointmentstatus;
	}
	public void setAppointmentstatus(String appointmentstatus) {
		this.appointmentstatus = appointmentstatus;
	}
	public SimpleDateFormat getDatetime() {
		return datetime;
	}
	public void setDatetime(SimpleDateFormat datetime) {
		this.datetime = datetime;
	}
	
}
