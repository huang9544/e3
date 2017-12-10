package cn.e3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.service.ItemService;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	/**
	 * 展示单个商品
	 * @param itemId
	 * @return
	 */
	@RequestMapping("item/findItem/{itemId}")
	@ResponseBody
	public TbItem findItem(@PathVariable Long itemId) {
		TbItem item = itemService.findById(itemId);
		return item;

	}
	/**
	 * 分页展示商品
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("item/list")
	@ResponseBody
	public DatagridPageBean list(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="30") Integer rows) {
		DatagridPageBean pageBean = itemService.findByPage(page, rows);
		return pageBean;
	}
	/**
	 * 保存
	 */
	@RequestMapping("/item/save")
	@ResponseBody
	public E3mallResult save(TbItem tbItem, TbItemDesc tbItemDesc) {
		E3mallResult e3mallResult = itemService.save(tbItem, tbItemDesc);
		return e3mallResult;
	}
}
