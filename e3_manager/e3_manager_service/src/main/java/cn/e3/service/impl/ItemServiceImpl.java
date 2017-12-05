package cn.e3.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.pojo.TbItemExample;
import cn.e3.service.ItemService;
import cn.e3.utils.DatagridPageBean;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public TbItem findById(Long itemId) {
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(itemId);
		return tbItem;
	}
	@Override
	public DatagridPageBean findByPage(Integer page, Integer rows) {
		DatagridPageBean pageBean = new DatagridPageBean();
		TbItemExample example = new TbItemExample();
		
		PageHelper.startPage(page, rows);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		long total = pageInfo.getTotal();
		
		pageBean.setTotal(total);
		pageBean.setRows(list);
		
		return pageBean;
	}

}
