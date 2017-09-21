	package com.northcar.carrent.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.northcar.carrent.dao.IRepairFactoryDAO;
import com.northcar.carrent.service.IRepairFactoryServiceBack;
import com.northcar.carrent.service.back.abs.AbstractService;
import com.northcar.carrent.vo.RepairFactory;

@Service
public class RepairFactoryServiceBackImpl extends AbstractService implements IRepairFactoryServiceBack {
	@Resource
	private IRepairFactoryDAO repairFactoryDAO;
	
	public Map<String, Object> list() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allRepairFactory", this.repairFactoryDAO.findAll()) ;
		return map;
	}
	
	public boolean edit(RepairFactory vo) {
		return this.repairFactoryDAO.doUpdate(vo) ;
	}

	public boolean add(RepairFactory vo) {
		return this.repairFactoryDAO.doCreate(vo);
	}

	public boolean delete(Integer id) {
		return this.repairFactoryDAO.doRemove(id) ;
	}

}
