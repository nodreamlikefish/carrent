package com.northcar.carrent.action.back;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.northcar.carrent.service.ICarTypeServiceBack;
import com.northcar.carrent.vo.CarType;
import com.northcar.util.action.abs.AbstractBaseAction;

@Controller
@RequestMapping("/pages/back/admin/carType/*")
public class CarTypeActionBack extends AbstractBaseAction {
	@Resource
	private ICarTypeServiceBack carTypeServiceBack;

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getUrl("carType.list.page"));
		Map<String, Object> map = this.carTypeServiceBack.list();
		mav.addObject("allCarTypes", map.get("allCarTypes")); // 保存所有的部门信息
		return mav;
	}

	@RequestMapping("edit")
	public ModelAndView edit(HttpServletResponse response,CarType vo) {
		super.print(response, this.carTypeServiceBack.edit(vo));
		return null;
	}
	@RequestMapping("addPre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("carType.add.page"));
		return mav;
	}
	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response,CarType vo) {
		String carType = request.getParameter("carType") ;
		vo.setCarType(carType);
		super.print(response, this.carTypeServiceBack.add(vo));
		return null;
	}
	@RequestMapping("delete")
	public ModelAndView delete(HttpServletResponse response,Integer id) {
		super.print(response, this.carTypeServiceBack.delete(id));
		return null;
	}
}
