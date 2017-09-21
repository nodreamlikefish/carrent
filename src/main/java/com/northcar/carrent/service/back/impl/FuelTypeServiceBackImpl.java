	package com.northcar.carrent.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.northcar.carrent.dao.IFuelTypeDAO;
import com.northcar.carrent.service.IFuelTypeServiceBack;
import com.northcar.carrent.service.back.abs.AbstractService;
import com.northcar.carrent.vo.FuelType;

@Service
public class FuelTypeServiceBackImpl extends AbstractService implements IFuelTypeServiceBack {
	@Resource
	private IFuelTypeDAO fuelTypeDAO;
	
	public Map<String, Object> list() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allFuelTypes", this.fuelTypeDAO.findAll()) ;
		return map;
	}
	
	public boolean edit(FuelType vo) {
		return this.fuelTypeDAO.doUpdate(vo) ;
	}

	public boolean add(FuelType vo) {
		return this.fuelTypeDAO.doCreate(vo);
	}

	public boolean delete(Integer id) {
		return this.fuelTypeDAO.doRemove(id) ;
	}

}
