package com.lph.sevice;

import java.util.List;

import com.lph.entity.Power;
import com.lph.entity.Role;

public interface RoleSevice {
	/**
	 * 获得所有角色及其信息，包括 角色id，角色名称 权限信息
	 * @return
	 */
    public List<Role> selectAllRoles();
    /**
     * 获得所有权限
     * @return
     */
    public List<Power> selectAllPower();
    /**
     * 添加角色，包括权限
     * @param role
     * @return
     */
    public Boolean addRole(Role role);
    /**
     * 删除角色，包括权限
     * @param rid
     * @return
     */
    public Boolean deleteRole(int rid);
    /**
     * 通过rid查询角色，得到的角色包括权限
     * @param rid
     * @return
     */
    public Role selecRoleByRid(int rid);
    /**
     * 修改角色，包括权限
     * @param role
     * @return
     */
    public Boolean updateRole(Role role);
}
