package cn.e3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.pojo.TbItem;
import cn.e3.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("item/findItem/{itemId}")
	@ResponseBody
	public TbItem findItem(@PathVariable Long itemId) {
		TbItem item = itemService.findById(itemId);
		return item;

	}
}
