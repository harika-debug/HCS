package com.cg.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admins")
public class Admins {
	@Id
	@Column(name="adminid")
	private String adminid;
	@Column(name="adminname")
	private String adminname;
	@Column(name="adminpassword")
	private String adminpassword;
	
	
	public Admins() {}
public Admins(String adminid, String adminname, String adminpassword) {
		this.adminid = adminid;
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
}
