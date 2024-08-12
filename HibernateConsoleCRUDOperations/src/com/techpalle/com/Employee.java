package com.techpalle.com;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int eno;
	private String ename;
	private int esal;
	private String edesg;
	public Employee() {
		
	}
	public Employee(int eno, String ename, int esal, String edesg) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.esal = esal;
		this.edesg = edesg;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEsal() {
		return esal;
	}
	public void setEsal(int esal) {
		this.esal = esal;
	}
	public String getEdesg() {
		return edesg;
	}
	public void setEdesg(String edesg) {
		this.edesg = edesg;
	}
	

}
