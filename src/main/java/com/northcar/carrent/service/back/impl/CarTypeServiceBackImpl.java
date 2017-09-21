	package com.northcar.carrent.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.northcar.carrent.dao.ICarTypeDAO;
import com.northcar.carrent.service.ICarTypeServiceBack;
import com.northcar.carrent.service.back.abs.AbstractService;
import com.northcar.carrent.vo.CarType;

@Service
public class CarTypeServiceBackImpl extends AbstractService implements ICarTypeServiceBack {
	@Resource
	private ICarTypeDAO carTypeDAO;
	
	public Map<String, Object> list() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allCarTypes", this.carTypeDAO.findAll()) ;
		return map;
	}
	
	public boolean edit(CarType vo) {
		return this.carTypeDAO.doUpdate(vo) ;
	}

	public boolean add(CarType vo) {
		return this.carTypeDAO.doCreate(vo);
	}

	public boolean delete(Integer id) {
		return this.carTypeDAO.doRemove(id) ;
	}

}
