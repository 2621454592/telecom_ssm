package com.lph.entity;

import java.util.List;

public class Role {
    private int id;  //角色id
    private String rname; //角色名
    private List<Power> listpower;
    
    
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int id, String rname) {
		super();
		this.id = id;
		this.rname = rname;
	}
	
	
	/**
	 * 得到listpower已转化为字符串
	 * @return
	 */
	public String getList() {
		String s="";
		if(listpower!=null) {
			for(int i=0;i<listpower.size();i++) {
				 if(i==listpower.size()-1)
					 s=s+listpower.get(i).getPname();
				 else s=s+listpower.get(i).getPname()+",";			
			}
		}
		
		return s;
	}
	public void setListpower(List<Power> listpower) {
		this.listpower = listpower;
	}
	public List<Power> getListpower() {
		return listpower;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
    
}
