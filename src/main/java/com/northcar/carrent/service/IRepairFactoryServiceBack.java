package com.northcar.carrent.service;

import java.util.Map;

import com.northcar.carrent.vo.RepairFactory;

public interface IRepairFactoryServiceBack {
	/**
	 * 列出全部的车辆类型 ；
	 * @return 返回的集合包含以下数据：<br>
	 * key = allCarType、value = 所有车辆颜色的集合；<br>
	 */
	public Map<String,Object> list() ;
	/**
	 * 修改汽车类型信息
	 * @param vo 包含需要修改的汽车编号及汽车的类型信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean edit(RepairFactory vo) ;
	/**
	 * 增加汽车类型信息
	 * @param vo 包含汽车的类型信息
	 * @return	成功返回true，失败返回false
	 */
	public boolean add(RepairFactory vo) ;
	/**
	 * 根据汽车类型的id删除其数据
	 * @param vo 包含汽车的类型的id
	 * @return 成功返回true，失败返回false
	 */
	public boolean delete(Integer id) ;
}
