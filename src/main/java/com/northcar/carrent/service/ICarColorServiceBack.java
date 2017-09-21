package com.northcar.carrent.service;

import java.util.Map;

import com.northcar.carrent.vo.CarColor;

public interface ICarColorServiceBack {
	/**
	 * 列出全部的车辆颜色信息 ；
	 * @return 返回的集合包含以下数据：<br>
	 * key = allCarColor、value = 所有车辆颜色的集合；<br>
	 */
	public Map<String,Object> list() ;
	/**
	 * 修改汽车颜色信息
	 * @param vo 包含需要修改的汽车编号及其修改后的颜色信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean edit(CarColor vo) ;
	/**
	 * 增加汽车颜色信息
	 * @param vo 包含汽车的颜色信息
	 * @return	成功返回true，失败返回false
	 */
	public boolean add(CarColor vo) ;
	/**
	 * 根据汽车颜色的id删除其数据
	 * @param vo 包含汽车的颜色的id
	 * @return 成功返回true，失败返回false
	 */
	public boolean delete(Integer id) ;
}
