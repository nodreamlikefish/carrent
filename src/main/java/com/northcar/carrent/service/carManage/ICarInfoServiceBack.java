package com.northcar.carrent.service.carManage;

import java.util.Map;

import com.northcar.carrent.vo.carManage.CarInfo;

public interface ICarInfoServiceBack {
	/**
	 * 列出全部的车辆信息 ；
	 * @return 返回的集合包含以下数据：<br>
	 * key = allCarInfo、value = 所有车辆颜色的集合；<br>
	 */
	public Map<String,Object> list() ;
	/**
	 * 修改汽车类型信息
	 * @param vo 包含需要修改的汽车编号及汽车的类型信息
	 * @return 成功返回true，失败返回false
	 */
	public boolean edit(CarInfo vo) ;
	/**
	 * 通过id查得本条信息的所有数据
	 * @param carId
	 * @return
	 */
	public CarInfo findById(Integer carId) ;
	/**
	 * 增加汽车类型信息
	 * @param vo 包含汽车的类型信息
	 * @return	成功返回true，失败返回false
	 */
	public boolean add(CarInfo vo) ;
	/**
	 * 根据汽车类型的id删除其数据
	 * @param vo 包含汽车的类型的id
	 * @return 成功返回true，失败返回false
	 */
	public boolean delete(Integer id) ;
}
