package com.lph.dao;

import java.util.List;

import com.lph.entity.Power;

public interface PowerDao {
	/**
	 * 通过aid查询权限
	 * @param aid
	 * @return
	 */
    public List<Power> selectPowerByAid(int aid);
    /**
     * 通过rid查询所有权限	
     * @param rid
     * @return
     */
    public List<Power> selectPowerByRid(int rid);
    /**
     * 查询所有权限
     * @return
     */
    public List<Power> selectAllPower();
}
