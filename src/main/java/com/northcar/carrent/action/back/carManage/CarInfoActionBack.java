package com.northcar.carrent.action.back.carManage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.northcar.carrent.service.ICarBelongServiceBack;
import com.northcar.carrent.service.ICarColorServiceBack;
import com.northcar.carrent.service.ICarOwnerServiceBack;
import com.northcar.carrent.service.ICarTypeServiceBack;
import com.northcar.carrent.service.IFuelTypeServiceBack;
import com.northcar.carrent.service.carManage.ICarInfoServiceBack;
import com.northcar.carrent.vo.CarBelong;
import com.northcar.carrent.vo.carManage.CarInfo;
import com.northcar.util.action.abs.AbstractBaseAction;

@Controller
@RequestMapping("/pages/back/admin/carManage/carInfo/*")
public class CarInfoActionBack extends AbstractBaseAction {
	@Resource
	private ICarInfoServiceBack iCarInfoServiceBack;

	@Resource
	private ICarBelongServiceBack iCarBelongServiceBack;

	@Resource
	private ICarOwnerServiceBack iCarOwnerServiceBack;

	@Resource
	private ICarTypeServiceBack iCarTypeServiceBack;

	@Resource
	private IFuelTypeServiceBack iFuelTypeServiceBack;

	@Resource
	private ICarColorServiceBack iCarColorServiceBack;

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getUrl("carInfo.list.page"));
		Map<String, Object> map = this.iCarInfoServiceBack.list();
		mav.addObject("carInfos", map.get("carInfos")); // 保存所有的部门信息
		return mav;
	}

	@RequestMapping("editPre")
	public ModelAndView editPre(HttpServletRequest request, String carId) {
		Integer carIdd = Integer.valueOf(carId);
		ModelAndView mav = new ModelAndView(super.getUrl("carInfo.edit.page"));
		mav.addObject("allCarOwners", iCarOwnerServiceBack.list().get("allCarOwners"));
		mav.addObject("allCarBelongs", iCarBelongServiceBack.list().get("allCarBelongs"));
		mav.addObject("allCarTypes", iCarTypeServiceBack.list().get("allCarTypes"));
		mav.addObject("allCarColor", iCarColorServiceBack.list().get("allCarColor"));
		mav.addObject("allFuelTypes", iFuelTypeServiceBack.list().get("allFuelTypes"));
		mav.addObject("carInfo", iCarInfoServiceBack.findById(carIdd));
		return mav;
	}

	@RequestMapping("edit")
	public ModelAndView edit(HttpServletResponse response, CarInfo vo, String buyDateStr, String nextYancheDateStr) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date buyDate = sdf.parse(buyDateStr);
		Date nextYancheDate = sdf.parse(nextYancheDateStr);
		vo.setBuyDate(buyDate);
		vo.setNextYancheDate(nextYancheDate);
		super.print(response, iCarInfoServiceBack.edit(vo));
		return null;
	}

	@RequestMapping("addPre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("carInfo.add.page"));
		mav.addObject("allCarOwners", iCarOwnerServiceBack.list().get("allCarOwners"));
		mav.addObject("allCarBelongs", iCarBelongServiceBack.list().get("allCarBelongs"));
		mav.addObject("allCarTypes", iCarTypeServiceBack.list().get("allCarTypes"));
		mav.addObject("allCarColor", iCarColorServiceBack.list().get("allCarColor"));
		mav.addObject("allFuelTypes", iFuelTypeServiceBack.list().get("allFuelTypes"));
		return mav;
	}

	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response, CarInfo vo, String buyDateStr,
			String nextYancheDateStr) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(buyDateStr != null && !"".equals(buyDateStr)){
			Date buyDate = sdf.parse(buyDateStr);
			vo.setBuyDate(buyDate);
		}
		if(nextYancheDateStr != null && !"".equals(nextYancheDateStr)){
			Date nextYancheDate = sdf.parse(nextYancheDateStr);
			vo.setNextYancheDate(nextYancheDate);
		}
		super.print(response, this.iCarInfoServiceBack.add(vo));
		return null;
	}

	@RequestMapping("delete")
	public ModelAndView delete(HttpServletResponse response, String carId) {
		Integer id = Integer.valueOf(carId) ;
		super.print(response, this.iCarInfoServiceBack.delete(id));
		return null;
	}
}
