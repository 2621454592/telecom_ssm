package com.lph.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lph.dao.AdminDao;
import com.lph.dao.PowerDao;
import com.lph.dao.RoleDao;
import com.lph.entity.Admin;
import com.lph.entity.Power;
import com.lph.entity.Role;
import com.lph.sevice.AdminSevice;
@Service("AdminSevice")
public class AdminServiceImpl implements AdminSevice {
	    @Autowired
        AdminDao ad;
	    @Autowired
        PowerDao pd;
	    @Autowired
        RoleDao rd;
	@Override
	public Admin checkUsernameAndPwd(Admin admin) {
		// TODO Auto-generated method stub
		 Admin adminy=ad.selectAdminByUsernameAndPwd(admin);
		 if(adminy!=null) {
			 List<Power> powerlist=pd.selectPowerByAid(adminy.getId());
			 List<Role>  rolelist=rd.selectRoleNameByAid(adminy.getId());
			 adminy.setPowerlist(powerlist);
			 adminy.setRoleList(rolelist);
		 }
		return adminy;
	}
	@Override
	public Boolean updatePwd(Admin admin) {
		// TODO Auto-generated method stub
		int i=ad.updateUserPwd(admin);
		return i>0?true:false;
	}
	@Override
	public Boolean updateUserinfo(Admin admin) {
		// TODO Auto-generated method stub
		int i=ad.updateUserinfo(admin);
		return i>0?true:false;
	}
	@Override
	public List<Admin> selectAllAdmin() {
		// TODO Auto-generated method stub
		List<Admin> adminlist=ad.selectAllAdmin();
        for(Admin admin:adminlist) {
        	List<Role> rolelist=rd.selectRoleNameByAid(admin.getId());
        	admin.setRoleList(rolelist);
        }
		return adminlist;
	}
	@Override
	public Boolean addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		ad.insertAdmin(admin);
		int i=ad.insertAdminRole(admin);
		return i>0?true:false;
	}
	@Override
	public Boolean deleteAdmin(int aid) {
		// TODO Auto-generated method stub
		int i=ad.deleteAdmin(aid);
		int j=ad.deleteAdminRole(aid);
		return i+j>=2?true:false;
	}
	@Override
	public Admin selectAdminByAid(int aid) {
		// TODO Auto-generated method stub
		 Admin admin=ad.selectAdminByAid(aid);
		 if(admin!=null) {
			 List rolelist=ad.selectAdminRole(aid);
			 admin.setRoleList(rolelist);
		 }
		 
		 
		return admin;
	}
	@Override
	public Boolean updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		int i=ad.updateAdmin(admin);
		int j=ad.deleteAdminRole(admin.getId());
		int m=ad.insertAdminRole(admin);
		return i+j+m>=3?true:false;
	}
	@Override
	public List<Admin> selectAdminByConditon(Admin admin) {
		// TODO Auto-generated method stub
		Role role=rd.selectRoleByRname(admin.getRoleList().get(0).getRname());
		    admin.getRoleList().get(0).setId(role.getId());
		List<Admin> adminlist=ad.selectAdminByCondition(admin);
		for(Admin admin1:adminlist) {
        	List<Role> rolelist=rd.selectRoleNameByAid(admin.getId());
        	admin1.setRoleList(rolelist);
        }
		return adminlist;
	}

}
