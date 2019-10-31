package com.lph.sevice;

import java.util.List;

import com.lph.entity.Admin;

public interface AdminSevice {
	    /**
	     * 检查账号密码
	     * 成功则继续获取权限
	     * 不成功则返回null
	     * @param admin
	     * @return
	     */
       public Admin checkUsernameAndPwd(Admin admin);
       /**
        * 修改密码
        * @param admin
        * @return
        */
       public Boolean updatePwd(Admin admin);
       /**
        * 修改个人信息
        */
       public Boolean updateUserinfo(Admin admin);
       /**
        * 查询所有管理员,里面含角色
        * @return
        */
       public List<Admin> selectAllAdmin();
       /**
        * 添加管理员，包括角色
        * @param admin
        * @return
        */
       public Boolean addAdmin(Admin admin);
       /**
        * 删除管理员，包括角色
        * @param aid
        * @return
        */
       public Boolean deleteAdmin(int aid);
       /**
        * 查询管理员包括角色
        * @param aid
        * @return
        */
       public Admin selectAdminByAid(int aid);
       /**
        * 修改管理员，包括角色
        * @param admin
        * @return
        */
       public Boolean updateAdmin(Admin admin);
       /**
        * 通过条件查询管理员
        * @param admin
        * @return
        */
       public List<Admin> selectAdminByConditon(Admin admin);
}
