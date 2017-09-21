package com.northcar.carrent.action.back;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.northcar.carrent.service.IFuelTypeServiceBack;
import com.northcar.carrent.vo.FuelType;
import com.northcar.util.action.abs.AbstractBaseAction;

@Controller
@RequestMapping("/pages/back/admin/fuelType/*")
public class FuelTypeActionBack extends AbstractBaseAction {
	@Resource
	private IFuelTypeServiceBack fuelTypeServiceBack;

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getUrl("fuelType.list.page"));
		Map<String, Object> map = this.fuelTypeServiceBack.list();
		mav.addObject("allFuelTypes", map.get("allFuelTypes")); // 保存所有的部门信息
		return mav;
	}

	@RequestMapping("edit")
	public ModelAndView edit(HttpServletResponse response,FuelType  vo) {
		super.print(response, this.fuelTypeServiceBack.edit(vo));
		return null;
	}
	@RequestMapping("addPre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("fuelType.add.page"));
		return mav;
	}
	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response,FuelType vo) {
		String fuel = request.getParameter("fuel") ;
		vo.setFuel(fuel);
		super.print(response, this.fuelTypeServiceBack.add(vo));
		return null;
	}
	@RequestMapping("delete")
	public ModelAndView delete(HttpServletResponse response,Integer id) {
		super.print(response, this.fuelTypeServiceBack.delete(id));
		return null;
	}
}
