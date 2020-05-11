package com.cg.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="Diagnostic_center")
public class Diagnostic_center {
	
	@Id
	@Column(name="centreid")
	private int centreid;
	@Column(name="centrename")
	private String centrename;
	@Column(name="centrePhno")
	private long centrePhno;
	@Column(name="centreAdd")
	private String centreAdd;
	
	
/*
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="centreid",referencedColumnName="centreid")
	private List<Testclass> test= new ArrayList<Testclass>();
	
	
	public List<Testclass> getTest() {
		return test;
	}
	public void setTest(List<Testclass> test) {
		this.test = test;
	}
	
	*/
	
	public Diagnostic_center() {}
	public Diagnostic_center(int centreid, String centrename, long centrePhno, String centreAdd) {
		
		this.centreid = centreid;
		this.centrename = centrename;
		this.centrePhno = centrePhno;
		this.centreAdd = centreAdd;
	}
	
	public int getCentreid() {
		return centreid;
	}
	public void setCentreid(int centreid) {
		this.centreid = centreid;
	}
	public String getCentrename() {
		return centrename;
	}
	public void setCentrename(String centrename) {
		this.centrename = centrename;
	}
	public long getCentrePhno() {
		return centrePhno;
	}
	public void setCentrePhno(long centrePhno) {
		this.centrePhno = centrePhno;
	}
	public String getCentreAdd() {
		return centreAdd;
	}
	public void setCentreAdd(String centreAdd) {
		this.centreAdd = centreAdd;
	}
	
		
}
