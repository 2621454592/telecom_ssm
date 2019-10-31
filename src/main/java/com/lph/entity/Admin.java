package com.lph.entity;

import java.sql.Date;
import java.util.List;

public class Admin {
    private int id;   //管理员id
    private String aname;  //管理员名字
    private String apwd;  //管理员密码
    private String acname;  //管理员账号
    private String atel;   //电话号码
    private String aemail;   //email
    private String aimg;   //管理员头像
    
    private String createUser;
    private Date createTime; 
    private String updateUser;
    private Date updateTime;
    
    private String by001;
    private String by002;
    private int by003;
    private Date by004;
    
    private List<Power> powerlist;
    private List<Role>  roleList;
    
    
    
	public List<Role> getRoleList() {
		return roleList;
	}
	public String getRL(){
		String s="";
		if(roleList!=null) {
		for(int i=0;i<roleList.size();i++) {
			if(i==roleList.size()-1)
				s=s+roleList.get(i).getRname();
			else s=s+roleList.get(i).getRname()+",";  	
		}
		}
		 return s;
		
	}
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	public List<Power> getPowerlist() {
		return powerlist;
	}
	public void setPowerlist(List<Power> powerlist) {
		this.powerlist = powerlist;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Admin(List<Power> powerlist, List<Role> roleList) {
		super();
		this.powerlist = powerlist;
		this.roleList = roleList;
	}
	public Admin(int id, String aname, String acname, String atel, String aemail, List<Role> roleList) {
		super();
		this.id = id;
		this.aname = aname;
		this.acname = acname;
		this.atel = atel;
		this.aemail = aemail;
		this.roleList = roleList;
	}
	public Admin(int id, String aname, String apwd, String acname, String atel, String aemail, List<Role> roleList) {
		super();
		this.id = id;
		this.aname = aname;
		this.apwd = apwd;
		this.acname = acname;
		this.atel = atel;
		this.aemail = aemail;
		this.roleList = roleList;
	}
	public Admin(String aname, String apwd, String acname, String atel, String aemail, String aimg, String createUser,
			List<Role> roleList) {
		super();
		this.aname = aname;
		this.apwd = apwd;
		this.acname = acname;
		this.atel = atel;
		this.aemail = aemail;
		this.aimg = aimg;
		this.createUser = createUser;
		this.roleList = roleList;
	}
	public Admin(int id, String aname, String acname, String atel, String aemail) {
		super();
		this.id = id;
		this.aname = aname;
		this.acname = acname;
		this.atel = atel;
		this.aemail = aemail;
	}
	public Admin(String apwd, String acname) {
		super();
		this.apwd = apwd;
		this.acname = acname;
	}
	public Admin(int id, String apwd, String acname) {
		super();
		this.id = id;
		this.apwd = apwd;
		this.acname = acname;
	}
	public Admin(String aname2, String apwd2, String acname2, String atel2, String aemail2, String createuser2,
			List<Role> rolelist2) {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	public String getAcname() {
		return acname;
	}
	public void setAcname(String acname) {
		this.acname = acname;
	}
	public String getAtel() {
		return atel;
	}
	public void setAtel(String atel) {
		this.atel = atel;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getAimg() {
		return aimg;
	}
	public void setAimg(String aimg) {
		this.aimg = aimg;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getBy001() {
		return by001;
	}
	public void setBy001(String by001) {
		this.by001 = by001;
	}
	public String getBy002() {
		return by002;
	}
	public void setBy002(String by002) {
		this.by002 = by002;
	}
	public int getBy003() {
		return by003;
	}
	public void setBy003(int by003) {
		this.by003 = by003;
	}
	public Date getBy004() {
		return by004;
	}
	public void setBy004(Date by004) {
		this.by004 = by004;
	}
    
}
