package cn.e3.service;

import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.DatagridPageBean;
import cn.e3.utils.E3mallResult;

public interface ItemService {

	public TbItem findById(Long itemId);
	/**
	 * 分页展示
	 * @param page
	 * @param rows
	 * @return
	 */
	public DatagridPageBean findByPage(Integer page, Integer rows);
	/**
	 * 保存商品
	 * @return
	 */
	public E3mallResult save(TbItem item, TbItemDesc itemDesc);
}
