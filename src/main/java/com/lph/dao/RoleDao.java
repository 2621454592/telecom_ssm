package com.lph.dao;

import java.util.List;

import com.lph.entity.Role;

public interface RoleDao {
	/**
	 * 通过aid查询角色名称
	 * @param aid
	 * @return
	 */
   public List<Role> selectRoleNameByAid(int aid);
   /**
    * 查询所有角色
    * @return
    */
   public List<Role> selectAllRole();
   /**
    * 添加角色 返回id
    * @param role
    * @return
    */
   public int addRole(Role role);
   /**
    * 为角色添加权限
    * @param role
    * @return
    */
   public int insertRolePower(Role role);
   /**
    * 删除角色
    * @param rid
    * @return
    */
   public int deleteRole(int rid);
   /**
    * 删除角色权限
    * @param rid
    * @return
    */
   public int deleteRolePower(int rid);
   /**
    * 通过rid查询角色
    * @param rid
    * @return
    */
   public Role selectRoleByRid(int rid);
   /**
    * 修改角色
    * @param role
    * @return
    */
   public int updateRole(Role role);
   /**
    * 通过角色名查询角色
    * @param rname
    * @return
    */
   public Role selectRoleByRname(String rname);
   
   
}
