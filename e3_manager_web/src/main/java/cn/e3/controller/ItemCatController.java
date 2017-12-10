package cn.e3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.service.ItemCatService;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.TreeNode;

@Controller
public class ItemCatController {

	@Autowired
	private ItemCatService service;
	
	/**
	 * 展示商品分类
	 * @param parentId
	 * @return
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<TreeNode> findItemCatTreeNodeList(@RequestParam(defaultValue="0",value="id") Long parentId){
		List<TreeNode> list = service.findItemCatTreeNodeList(parentId);
		return list;
	} 
}
