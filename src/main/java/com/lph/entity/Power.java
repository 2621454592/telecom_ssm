package com.lph.entity;

public class Power {
     private int id;   //权限id
     private String pclass;  //权限样式
     private String purl;    //权限地址
     private String pname;  //权限名
     private int pstate; //权限状态
	public Power() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Power(int id, String pclass, String purl) {
		super();
		this.id = id;
		this.pclass = pclass;
		this.purl = purl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPclass() {
		return pclass;
	}
	public void setPclass(String pclass) {
		this.pclass = pclass;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPstate() {
		return pstate;
	}
	public void setPstate(int pstate) {
		this.pstate = pstate;
	}

	
      
}
