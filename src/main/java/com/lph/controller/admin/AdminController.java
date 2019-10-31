package com.lph.controller.admin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.lph.dao.PowerDao;
import com.lph.entity.Admin;
import com.lph.sevice.AdminSevice;
import com.lph.sevice.PowerSevice;
import com.lph.sevice.RoleSevice;
import com.lph.entity.Role;

import com.lph.entity.Power;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
   AdminSevice as;
	@Autowired
	PowerSevice ps;
	@Autowired
	RoleSevice  rs;
	@RequestMapping("/login")
	public String login() {   //登陆
		return "login";
	}
	@RequestMapping("/index1")
	public String index1() {  //主页
		return "index";
	}
	@RequestMapping("/user_modi_pwd")
	public String user_modi_pwd() {    //修改密码
		return "user/user_modi_pwd";
	}
	@RequestMapping("/user_modi_pwd_do")
	public String user_modi_pwd_do(HttpServletRequest request, HttpServletResponse response) {
		String oldpwd= request.getParameter("oldpwd");
		 String newpwd= request.getParameter("newpwd");
		 Admin admin=(Admin) request.getSession().getAttribute("admin");
		 if(oldpwd.equals(admin.getApwd())) {
			  admin.setApwd(newpwd);
			  Boolean b=as.updatePwd(admin);
			  if(b) {
				  return "redirect:login";
			  }else {
				  request.setAttribute("emspwd", "对不起修改密码失败");
				 return "forward:user_modi_pwd";
			  }
			  
		 }else {
			    request.setAttribute("emspwd", "旧密码不正确");
			    return "forward:user_modi_pwd";
		 }
	}
	@RequestMapping("/user_info")
	public String user_info() {      //修改个人信息
		return "user/user_info";
	}
	@RequestMapping("/user_info_do")
	public void user_info_do(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String acname=request.getParameter("acname");
		String aname=request.getParameter("name");
		String atel=request.getParameter("tel");
		String aemail=request.getParameter("email");
		String aid=request.getParameter("aid");
		Boolean b=as.updateUserinfo(new Admin(Integer.parseInt(aid), aname, acname, atel, aemail));
		if(b) {
		Admin admin=(Admin)request.getSession().getAttribute("admin");
		admin.setAname(aname);
		admin.setAtel(atel);
		admin.setAemail(aemail);
		request.getSession().setAttribute("admin", admin);
		try {
			response.getWriter().print("ok");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else {
		try {
			response.getWriter().print("fail");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
	}
	@RequestMapping("/ExitAction")
	public String ExitAction(HttpServletRequest request) { //退出
		request.getSession().invalidate();
		return "redirect:login";
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  String acname=request.getParameter("acname");
		  String apwd=request.getParameter("apwd");
		  Admin admin=as.checkUsernameAndPwd(new Admin(apwd, acname));
		  request.getSession().setAttribute("admin", admin);
		if (admin != null) {
			return "index";
		} else {
			return "login";
		}
	}
	@RequestMapping("/admin_list")
	public String Admin_list() {      //进入管理员界面
		return "admin/admin_list";
	}
	@RequestMapping("/ShowAdminList")
	public String ShowAdminList(HttpServletRequest request) {
		 List<Admin> adminlist= as.selectAllAdmin();
		  List<Power> powerlist=ps.selectAllPower();
		  request.setAttribute("adminlist", adminlist);
		  request.setAttribute("powerlist", powerlist);  //显示所有管理员
		  return "forward:admin_list";
	}
	@RequestMapping("showAddAdminAction")
	public String showAddAdminAction(HttpServletRequest request) {
		List<Role> rolelist=rs.selectAllRoles();
		request.setAttribute("rolelist", rolelist);  //进入添加管理员界面
		return "admin/admin_add";
	}
	@RequestMapping("/AddAdminAction")
	public String AddAdminAction(HttpServletRequest request) throws IOException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String aname=request.getParameter("aname");
		String acname=request.getParameter("acname");
		String apwd=request.getParameter("apwd");
		String atel=request.getParameter("atel");
		String aemail=request.getParameter("aemail");
		Admin sadmin=(Admin) request.getSession().getAttribute("admin");
		String createuser=sadmin.getAcname();
		
		Part img = null;
		try {
			img = request.getPart("aimg");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	String aimg="/AdminImg/"+img.getSubmittedFileName();
		
		String[] role=request.getParameterValues("role");
		List<Role> rolelist=new ArrayList();
		for(String rid:role) {
			Role role1=new Role();
			role1.setId(Integer.parseInt(rid));
			rolelist.add(role1);
		}
		boolean b=as.addAdmin(new Admin(aname, apwd, acname, atel, aemail,null,createuser, rolelist));
		if(b) {
			/*
			 * InputStream is=img.getInputStream(); FileOutputStream fos=new
			 * FileOutputStream(request.getServletContext().getRealPath("/AdminImg/")+img.
			 * getSubmittedFileName()); int c=0; if((c=is.read())!=-1) { fos.write(c); }
			 * is.close(); fos.close();+
			 */
			request.setAttribute("msg","添加成功");
			return "forward:showAddAdminAction";
		}else {
			request.setAttribute("msg","添加失败");
			return "forward:showAddAdminAction";
		}
	}
	@RequestMapping("/DeleteAdminAction")
	public String DeleteAdminAction(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String aid=request.getParameter("aid");
		boolean b=as.deleteAdmin(Integer.parseInt(aid));
		if(b) {
			request.setAttribute("msg", "删除成功");
			return "forward:ShowAdminList";
		}else {
			request.setAttribute("msg", "删除失败");
			return "forward:ShowAdminList";
		}
	}
	

}
