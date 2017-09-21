package com.northcar.carrent.action.back;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.northcar.carrent.service.IRepairFactoryServiceBack;
import com.northcar.carrent.vo.RepairFactory;
import com.northcar.util.action.abs.AbstractBaseAction;

@Controller
@RequestMapping("/pages/back/admin/repairFactory/*")
public class RepairFactoryActionBack extends AbstractBaseAction {
	@Resource
	private IRepairFactoryServiceBack repairFactoryServiceBack;

	@RequestMapping("list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView(super.getUrl("repairFactory.list.page"));
		Map<String, Object> map = this.repairFactoryServiceBack.list();
		mav.addObject("allRepairFactory", map.get("allRepairFactory")); // 保存所有的部门信息
		return mav;
	}

	@RequestMapping("edit")
	public ModelAndView edit(HttpServletResponse response,RepairFactory  vo) {
		super.print(response, this.repairFactoryServiceBack.edit(vo));
		return null;
	}
	@RequestMapping("addPre")
	public ModelAndView addPre() {
		ModelAndView mav = new ModelAndView(super.getUrl("repairFactory.add.page"));
		return mav;
	}
	@RequestMapping("add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response,RepairFactory vo) {
		String repairFactory = request.getParameter("repairFactory") ;
		vo.setRepairFactory(repairFactory);
		super.print(response, this.repairFactoryServiceBack.add(vo));
		return null;
	}
	@RequestMapping("delete")
	public ModelAndView delete(HttpServletResponse response,Integer id) {
		super.print(response, this.repairFactoryServiceBack.delete(id));
		return null;
	}
}
