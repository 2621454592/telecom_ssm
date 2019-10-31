package com.lph.dao;

import java.util.List;

import com.lph.entity.Admin;
import com.lph.entity.Role;

public interface AdminDao {
	  /**
	      * 通过账号密码查询admin
	   * @param admin
	   * @return Admin
	   */
      public Admin selectAdminByUsernameAndPwd(Admin admin);
      /**
            * 修改用户密码
       * @param admin
       * @return
       */
      public int updateUserPwd(Admin admin);
      
      /**
       * 修改个人信息
       * @param admin
       * @return
       */
      public int updateUserinfo(Admin admin);
     /**
      * 查询所有管理员
      * @return
      */
      public List<Admin> selectAllAdmin();
      /**
       * 添加管理员,不包括角色和权限
       * @return
       */
      public int insertAdmin(Admin admin);
      /**
       * 添加管理员角色
       * @return
       */
      public int insertAdminRole(Admin admin);
     /**
      * 删除管理员
      * @param aid
      * @return
      */
      public int deleteAdmin(int aid);
      /**
       * 删除管理员角色
       * @param aid
       * @return
       */
      public int deleteAdminRole(int aid);
      /**
       * 通过aid查询管理员
       * @param aid
       * @return
       */
      public Admin selectAdminByAid(int aid);
      /**
       * 通过aid查询管理员角色
       * @param aid
       * @return
       */
      public List<Role> selectAdminRole(int aid);
      /**
       * 修改管理员信息
       * @param 
       * @return
       */
      public int updateAdmin(Admin admin);
      /**
       * 通过条件查询管理员
       * @param admin
       * @return
       */
      public List<Admin> selectAdminByCondition(Admin admin);
} 
