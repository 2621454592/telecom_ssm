package com.lph.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lph.dao.PowerDao;
import com.lph.dao.RoleDao;
import com.lph.entity.Power;
import com.lph.entity.Role;
import com.lph.sevice.RoleSevice;
@Service("RoleSevice")
public class RoleSeviceImpl implements RoleSevice {
	@Autowired
       RoleDao rd;
	@Autowired
       PowerDao pd;
	@Override
	public List<Role> selectAllRoles() {
		// TODO Auto-generated method stub
		List<Role> listrole=rd.selectAllRole();
		for(Role r:listrole) {
			List<Power> listpower=pd.selectPowerByRid(r.getId());	
			r.setListpower(listpower);
		}
		return listrole;
	}
	@Override
	public List<Power> selectAllPower() {
		// TODO Auto-generated method stub
		return pd.selectAllPower();
	}
	@Override
	public Boolean addRole(Role role) {
		// TODO Auto-generated method stub
		    rd.addRole(role);
		System.out.println(role.getId());
			
			int i=rd.insertRolePower(role);
		return i>0?true:false;
	}
	@Override
	public Boolean deleteRole(int rid) {
		// TODO Auto-generated method stub
		int i=rd.deleteRole(rid);
		int j=rd.deleteRolePower(rid);		
		return i+j>=2?true:false;
	}
	@Override
	public Role selecRoleByRid(int rid) {
		// TODO Auto-generated method stub
		Role r=rd.selectRoleByRid(rid);
		List<Power> listpower=pd.selectPowerByRid(rid);
		r.setListpower(listpower);
		return r;
	}
	@Override
	public Boolean updateRole(Role role) {
		// TODO Auto-generated method stub
		int i=rd.updateRole(role);
		int j=rd.deleteRolePower(role.getId());
		int m=rd.insertRolePower(role);
		return i+j+m>=3?true:false;
	}

}
