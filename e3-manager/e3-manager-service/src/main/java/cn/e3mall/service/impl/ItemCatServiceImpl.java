package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.EasyUITreeNode;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	/**
	 * 获取所有父节点列表信息
	 * @return
	 */
	public List<EasyUITreeNode> getCatList(Long parentId){
		//根据parentId查询节点列表
		TbItemCatExample example=new TbItemCatExample();
		//设置查询条件
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
		//转换成EsayUITreeNode列表
		List<EasyUITreeNode> easyUITreeNodeList=new ArrayList<EasyUITreeNode>();
		for (int i = 0; i < tbItemCats.size(); i++) {
			EasyUITreeNode easyUITreeNode=new EasyUITreeNode();
			TbItemCat tbItemCat = tbItemCats.get(i);
			easyUITreeNode.setId(tbItemCat.getId());
			easyUITreeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			easyUITreeNode.setText(tbItemCat.getName());
			//添加到列表
			easyUITreeNodeList.add(easyUITreeNode);
		}
		//返回结果
		return easyUITreeNodeList;
	}
}
