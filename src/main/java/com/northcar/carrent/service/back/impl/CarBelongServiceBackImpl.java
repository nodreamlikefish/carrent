	package com.northcar.carrent.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.northcar.carrent.dao.ICarBelongDAO;
import com.northcar.carrent.service.ICarBelongServiceBack;
import com.northcar.carrent.service.back.abs.AbstractService;
import com.northcar.carrent.vo.CarBelong;

@Service
public class CarBelongServiceBackImpl extends AbstractService implements ICarBelongServiceBack {
	@Resource
	private ICarBelongDAO carBelongDAO;
	
	public Map<String, Object> list() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allCarBelongs", this.carBelongDAO.findAll()) ;
		return map;
	}
	
	public boolean edit(CarBelong vo) {
		return this.carBelongDAO.doUpdate(vo) ;
	}

	public boolean add(CarBelong vo) {
		return this.carBelongDAO.doCreate(vo);
	}

	public boolean delete(Integer id) {
		return this.carBelongDAO.doRemove(id) ;
	}

}
