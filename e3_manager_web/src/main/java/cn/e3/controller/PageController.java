package cn.e3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.service.ItemService;
import cn.e3.utils.DatagridPageBean;

@Controller
public class PageController {

	@Autowired
	private ItemService service;
	
	@RequestMapping("{pageName}")
	public String showPage(@PathVariable String pageName) {
		return pageName;
	}
	
	@RequestMapping("item/list")
	@ResponseBody
	public DatagridPageBean list(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="30") Integer rows) {
		DatagridPageBean pageBean = service.findByPage(page, rows);
		return pageBean;
	}
}
