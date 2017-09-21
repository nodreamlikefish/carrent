package com.northcar.carrent.action.back;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.northcar.carrent.service.ICarColorServiceBack;
import com.northcar.carrent.vo.CarColor;
import com.northcar.util.action.abs.AbstractBaseAction;

@Controller
@RequestMapping("/pages/back/admin/carColor/*")
public class CarColorActionBack extends AbstractBaseAction {
	@Resource
	private ICarColorServiceBack carColorServiceBack;

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getUrl("carColor.list.page"));
		Map<String, Object> map = this.carColorServiceBack.list();
		mav.addObject("allCarColor", map.get("allCarColor")); // 保存所有的部门信息
		return mav;
	}

	@RequestMapping("edit")
	public ModelAndView edit(HttpServletResponse response,CarColor vo) {
		super.print(response, this.carColorServiceBack.edit(vo));
		return null;
	}
	@RequestMapping("addPre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("carColor.add.page"));
		return mav;
	}
	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response,CarColor vo) {
		String color = request.getParameter("color") ;
		vo.setColor(color);
		super.print(response, this.carColorServiceBack.add(vo));
		return null;
	}
	@RequestMapping("delete")
	public ModelAndView delete(HttpServletResponse response,Integer id) {
		super.print(response, this.carColorServiceBack.delete(id));
		return null;
	}
}
