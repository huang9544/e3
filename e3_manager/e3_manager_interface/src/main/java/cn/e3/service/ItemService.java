package cn.e3.service;

import cn.e3.pojo.TbItem;
import cn.e3.utils.DatagridPageBean;

public interface ItemService {

	public TbItem findById(Long itemId);
	public DatagridPageBean findByPage(Integer page, Integer rows);
}
