package cn.e3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	/**
	 * 页面跳转
	 * @param pageName
	 * @return
	 */
	@RequestMapping("{pageName}")
	public String showPage(@PathVariable String pageName) {
		return pageName;
	}
	
	
}
