package com.lph.controller.role;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lph.sevice.RoleSevice;

import com.lph.entity.Power;

import com.lph.entity.Role;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleSevice rs;
       @RequestMapping("/rolelist")
	 public String rolelist() {
		 return "role/role_list";   //跳转到role_list页面
	 }
       @RequestMapping("/rolelist_do")
     public String ShowRoleListAction(HttpServletRequest request) {
    	 List<Role> roles=rs.selectAllRoles();
 		request.setAttribute("roles", roles);
 		return "forward:rolelist";
     }
       @RequestMapping("/roleadd")
      public String role_add() {      //跳转到role_add页面
    	  return "role/role_add";
      }
       @RequestMapping("/roleadd_do")
       public String AddRoleShowAllPowerAction(HttpServletRequest request) {
    	   List<Power> powerlist=rs.selectAllPower();
		   request.setAttribute("powerlist", powerlist);    
		   return "forward:roleadd";
       }
       @RequestMapping("/roleadd_doadd")
       public String AddRoleAction(HttpServletRequest request) {
    	   try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   		String rname=request.getParameter("rolename");
   		String[] power=request.getParameterValues("power");
   		List<Power> listpower=new ArrayList<>();
   		for(String pid:power) {
   			Power p=new Power();
   			p.setId(Integer.parseInt(pid));
   			listpower.add(p);
   		}
   		Role role=new Role();
   		role.setRname(rname);
   		role.setListpower(listpower);
   		Boolean b=rs.addRole(role);
   		if(b) {
   			request.setAttribute("armsg", "添加成功");
   			return "forward:roleadd_do";
   		}else {
   			request.setAttribute("armsg", "添加失败");
   			return "forward:roleadd_do";
   		}
       }

	@RequestMapping("/roledelete")
	public String DeleteRoleAction(HttpServletRequest request) {
		String rid = request.getParameter("rid");
		Boolean b = rs.deleteRole(Integer.parseInt(rid));
		if (b) {
			request.setAttribute("msg", "删除角色成功");     //删除角色
			return "forward:rolelist_do";
		} else {
			request.setAttribute("msg", "删除角色失败");
			return "forward:rolelist_do";
		}
	}
	@RequestMapping("ShowRole_Modi")
	public String ShowRole_Modi() {
		return "role/role_modi";
	}
	
	@RequestMapping("/ShowUpdateAction")
	public String ShowUpdateAction(HttpServletRequest request) {
		String s=request.getParameter("rid");
		Role role=rs.selecRoleByRid(Integer.parseInt(s));
		List<Power> powerlist=rs.selectAllPower();
		request.setAttribute("role", role);
		request.setAttribute("powerlist", powerlist);
		return "forward:ShowRole_Modi";
	}
	@RequestMapping("/UpdateAction")
	public String UpdateAction(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String rid=request.getParameter("rid");
	    String rname=request.getParameter("rname");
	    String[] power=request.getParameterValues("power");
	    List<Power> powerlist=new ArrayList();
	    for(String p:power) {
	    	 Power rp=new Power();
	    	 rp.setId(Integer.parseInt(p));
	    	 powerlist.add(rp);
	    }
	    Role role=new Role();
	    role.setId(Integer.parseInt(rid));
	    role.setRname(rname);
	    role.setListpower(powerlist);
	    
	    Boolean b=rs.updateRole(role);
	    if(b) {
	    	request.setAttribute("msg", "修改成功");
	    	return "forward:ShowUpdateAction";
	    }else{
	    	request.setAttribute("msg", "修改失败");
	    	return "forward:ShowUpdateAction";
	    }
	}
	
}
