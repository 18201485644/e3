package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId ){
		TbItem tbItem =itemService.getItemById(itemId);
		return tbItem;
	}
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page,Integer rows){
		if(page==null||rows==null){
			page=1;
			rows=10;
		}
		EasyUIDataGridResult itemList = itemService.getItemList(page, rows);
		return itemList;
	}
}
