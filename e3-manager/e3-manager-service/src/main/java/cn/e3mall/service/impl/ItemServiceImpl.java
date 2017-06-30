package cn.e3mall.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;
	/**
	 * 根据商品id获取商品常用信息
	 */
	@Override
	public TbItem getItemById(long id) {
		TbItem item = itemMapper.selectByPrimaryKey(id);
		return item;
	}

}
