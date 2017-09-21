package com.northcar.carrent.action.back;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.northcar.carrent.service.ICarBelongServiceBack;
import com.northcar.carrent.vo.CarBelong;
import com.northcar.util.action.abs.AbstractBaseAction;

@Controller
@RequestMapping("/pages/back/admin/carBelong/*")
public class CarBelongActionBack extends AbstractBaseAction {
	@Resource
	private ICarBelongServiceBack carBelongServiceBack;

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getUrl("carBelong.list.page"));
		Map<String, Object> map = this.carBelongServiceBack.list();
		mav.addObject("allCarBelongs", map.get("allCarBelongs")); // 保存所有的部门信息
		return mav;
	}

	@RequestMapping("edit")
	public ModelAndView edit(HttpServletResponse response,CarBelong vo) {
		super.print(response, this.carBelongServiceBack.edit(vo));
		return null;
	}
	@RequestMapping("addPre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("carBelong.add.page"));
		return mav;
	}
	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response,CarBelong vo) {
		super.print(response, this.carBelongServiceBack.add(vo));
		return null;
	}
	@RequestMapping("delete")
	public ModelAndView delete(HttpServletResponse response,Integer id) {
		super.print(response, this.carBelongServiceBack.delete(id));
		return null;
	}
}
