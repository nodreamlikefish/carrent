package com.northcar.carrent.action.back;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.northcar.carrent.service.ICarOwnerServiceBack;
import com.northcar.carrent.vo.CarOwner;
import com.northcar.util.action.abs.AbstractBaseAction;

@Controller
@RequestMapping("/pages/back/admin/carOwner/*")
public class CarOwnerActionBack extends AbstractBaseAction {
	@Resource
	private ICarOwnerServiceBack carOwnerServiceBack;

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getUrl("carOwner.list.page"));
		Map<String, Object> map = this.carOwnerServiceBack.list();
		mav.addObject("allCarOwners", map.get("allCarOwners")); 
		return mav;
	}

	@RequestMapping("edit")
	public ModelAndView edit(HttpServletResponse response,CarOwner  vo) {
		super.print(response, this.carOwnerServiceBack.edit(vo));
		return null;
	}
	@RequestMapping("addPre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("carOwner.add.page"));
		return mav;
	}
	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response,CarOwner vo) {
		String owner = request.getParameter("owner") ;
		vo.setOwner(owner);
		super.print(response, this.carOwnerServiceBack.add(vo));
		return null;
	}
	@RequestMapping("delete")
	public ModelAndView delete(HttpServletResponse response,Integer id) {
		super.print(response, this.carOwnerServiceBack.delete(id));
		return null;
	}
}
