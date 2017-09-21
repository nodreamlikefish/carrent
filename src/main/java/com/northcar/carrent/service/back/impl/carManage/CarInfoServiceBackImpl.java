package com.northcar.carrent.service.back.impl.carManage;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.northcar.carrent.dao.carManage.ICarInfoDAO;
import com.northcar.carrent.service.back.abs.AbstractService;
import com.northcar.carrent.service.carManage.ICarInfoServiceBack;
import com.northcar.carrent.vo.carManage.CarInfo;

@Service
public class CarInfoServiceBackImpl extends AbstractService implements ICarInfoServiceBack {
	
	@Resource
	private ICarInfoDAO iCarInfoDAO ;
	
	public Map<String, Object> list() {
		Map<String, Object> map = new HashMap<String,Object>() ;
		map.put("carInfos", iCarInfoDAO.findAll()) ;
		return map;
	}

	public boolean edit(CarInfo vo) {
		return iCarInfoDAO.doUpdate(vo);
	}

	public boolean add(CarInfo vo) {
		
		return iCarInfoDAO.doCreate(vo);
	}

	public boolean delete(Integer id) {
		return iCarInfoDAO.doRemove(id);
	}

	public CarInfo findById(Integer carId) {
		return iCarInfoDAO.findById(carId);
	}

}
