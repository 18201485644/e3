package cn.e3mall.service;

import cn.e3mall.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;


/**
 * 商品管理
 * @author gys
 *
 */
public interface ItemService {
	/**
	 * 根据id获取商品信息
	 */
	TbItem getItemById(long id);
	/**
	 * 获取分页信息
	 */
	EasyUIDataGridResult getItemList(int page,int rows);
}
