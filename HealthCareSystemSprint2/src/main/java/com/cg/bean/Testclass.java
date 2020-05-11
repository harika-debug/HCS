package com.cg.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Testclass")
public class Testclass {
	@Id
	@Column(name="testid")
	private int testid;
	@Column(name="testname")
	private String testname;
	@Column(name="centrenum")
	private int centrenum;

	
	public Testclass() {}
	public Testclass(int testid, String testname, int centrenum) {
		
		this.testid = testid;
		this.testname = testname;
		this.centrenum = centrenum;
	}
	
	/*
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="centreid",referencedColumnName="centreid")
	private Diagnostic_center diagnostic_center;
	*/
	

public int getCentrenum() {
		return centrenum;
	}
	public void setCentrenum(int centrenum) {
		this.centrenum = centrenum;
	}
public int getTestid() {
	return testid;
}
public void setTestid(int testid) {
	this.testid = testid;
}
public String getTestname() {
	return testname;
}
public void setTestname(String testname) {
	this.testname = testname;
}



/*
public Diagnostic_center getDiagnostic_center() {
	return diagnostic_center;
}
public void setDiagnostic_center(Diagnostic_center diagnostic_center) {
	this.diagnostic_center = diagnostic_center;
}*/
}
