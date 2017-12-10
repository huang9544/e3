package cn.e3.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.e3.mapper.TbItemCatMapper;
import cn.e3.pojo.TbItemCat;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.pojo.TbItemCatExample.Criteria;
import cn.e3.service.ItemCatService;
import cn.e3.utils.TreeNode;

@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper mapper;
	/**
	 * 需求:根据父id查询此节点下面的子节点
	 * 参数:Long parentId
	 * 返回值:List<TreeNode>
	 * [{    
    	"id": 1,    
    	"text": "Node 1",    
    	"state": "closed"
    	}]
	 */
	@Override
	public List<TreeNode> findItemCatTreeNodeList(Long parentId) {
		
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		TbItemCatExample example = new TbItemCatExample();
		
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> itemList = mapper.selectByExample(example);
		for (TbItemCat tbItemCat : itemList) {
			TreeNode treeNode = new TreeNode();
			treeNode.setId(tbItemCat.getId());
			treeNode.setText(tbItemCat.getName());
			//如果is_parent=1,表示此节点有子节点,state="closed" 表示可打开状态
			//如果is_parent=0,表示没有子节点,state="open" 表示已经处于打开状态,没办法再打开
			treeNode.setState(tbItemCat.getIsParent() ? "closed" : "open");
			
			treeList.add(treeNode);
		}
		
		return treeList;
	}

}
