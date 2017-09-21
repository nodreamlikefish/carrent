	package com.northcar.carrent.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.northcar.carrent.dao.ICarOwnerDAO;
import com.northcar.carrent.service.ICarOwnerServiceBack;
import com.northcar.carrent.service.back.abs.AbstractService;
import com.northcar.carrent.vo.CarOwner;

@Service
public class CarOwnerServiceBackImpl extends AbstractService implements ICarOwnerServiceBack {
	@Resource
	private ICarOwnerDAO carOwnerDAO;
	
	public Map<String, Object> list() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allCarOwners", this.carOwnerDAO.findAll()) ;
		return map;
	}
	
	public boolean edit(CarOwner vo) {
		return this.carOwnerDAO.doUpdate(vo) ;
	}

	public boolean add(CarOwner vo) {
		return this.carOwnerDAO.doCreate(vo);
	}

	public boolean delete(Integer id) {
		return this.carOwnerDAO.doRemove(id) ;
	}

}
