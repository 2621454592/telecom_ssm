package com.lph.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lph.dao.PowerDao;
import com.lph.entity.Power;
import com.lph.sevice.PowerSevice;
@Service("PowerSevice")
public class PowerSeviceImpl implements PowerSevice {
	      @Autowired
          PowerDao pd;
	@Override
	public List<Power> selectAllPower() {
		// TODO Auto-generated method stub
		return pd.selectAllPower();
	}
         
}
