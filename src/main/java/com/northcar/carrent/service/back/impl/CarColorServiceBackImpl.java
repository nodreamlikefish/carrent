	package com.northcar.carrent.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.northcar.carrent.dao.ICarColorDAO;
import com.northcar.carrent.service.ICarColorServiceBack;
import com.northcar.carrent.service.back.abs.AbstractService;
import com.northcar.carrent.vo.CarColor;

@Service
public class CarColorServiceBackImpl extends AbstractService implements ICarColorServiceBack {
	@Resource
	private ICarColorDAO carColorDAO;
	
	public Map<String, Object> list() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allCarColor", this.carColorDAO.findAll()) ;
		return map;
	}
	
	public boolean edit(CarColor vo) {
		return this.carColorDAO.doUpdate(vo) ;
	}

	public boolean add(CarColor vo) {
		
		return this.carColorDAO.doCreate(vo);
	}

	public boolean delete(Integer id) {
		return this.carColorDAO.doRemove(id) ;
	}

}
