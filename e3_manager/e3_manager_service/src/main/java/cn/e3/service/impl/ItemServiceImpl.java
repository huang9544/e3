package cn.e3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public TbItem findById(Long itemId) {
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		return tbItem;
	}

}