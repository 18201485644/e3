package cn.e3mall.service;

import java.util.List;

import cn.e3mall.pojo.EasyUITreeNode;

public interface ItemCatService {
	/**
	 *获取父节点列表
	 * @param parentId
	 * @return
	 */
	List<EasyUITreeNode> getCatList(Long parentId);
}
