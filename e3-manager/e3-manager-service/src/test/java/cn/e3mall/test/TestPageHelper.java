package cn.e3mall.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.EasyUIDataGridResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;
/**
 * PageHelper.startPage(1, 10);  (设置当前页,页大小)→此类中他调用了page的构造方法,通过构造方法把两参数传递给了page
   TbItemExample example 查询条件对象
   List<TbItem>  list= tbItemMapper.selectByExample(example); 执行查询条件对象 返回一个信息list集合(其实这个list是page,page实现list的儿子 ArrayList  强转成 孙子类 这个时候page就有所有信息了)
   PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list); 然后将此信息传递给pageInfo 
 * @author gys
 *
 */
public class TestPageHelper {
	@Test
	public void testPageHelper() throws Exception {
		//初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//获得mapper代理对象(获得持久层接口代理对象)
		TbItemMapper tbItemMapper = applicationContext.getBean(TbItemMapper.class);
		//设置分页信息(当前页,页大小)
		PageHelper.startPage(1, 10);
		//执行查询
		TbItemExample example=new TbItemExample();
		List<TbItem> list= tbItemMapper.selectByExample(example);
		Page p=(Page) list;
		p.getPageSize();
		System.out.println("p.getPageSize()="+p.getPageSize());
		System.out.println(list instanceof Page);
		//取分页信息
		PageInfo<TbItem> pageInfo=new PageInfo<TbItem>(list);
		System.out.println("总数据数="+pageInfo.getTotal());
		System.out.println("总页数="+pageInfo.getPages());
		System.out.println("页大小="+pageInfo.getPageSize());
		System.err.println("当前页="+pageInfo.getPageNum());
		
	}
	@Test
	public void testGetItemList() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		ItemService itemService = applicationContext.getBean(ItemService.class);
		System.out.println(itemService);
		EasyUIDataGridResult itemList = itemService.getItemList(1,10);
		System.out.println("itemList="+itemList);
		
	}
	@Test
	public void testCriteriaIsSingleCaseOrNumberOfCases()throws Exception {
		/*Criteria criteria=example.createCriteria();
		 * 
		 *ParentIdEqualTo =某属性
		 *LessThan小于
		 *LessThanOrEqualTo 小于等于
		 *GreaterThan大于
		 *GreaterThanOrEqualTo 大于等于
		 * */
		TbItemExample example=new TbItemExample();
		Criteria criteria1=example.createCriteria();
		Criteria criteria2=example.createCriteria();
		System.out.println("criteria1==criteria2"+(criteria1==criteria2));
		System.out.println("criteria1="+criteria1);
		System.out.println("criteria2="+criteria2);
		/**
		 * 结论criteria是多例
		 * createCriteria拼装查询语句过程中使用的对象是单利模式!
		 */
	}
	@Test
	public void testName() throws Exception {
		//初始化spring容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//获得mapper代理对象(获得持久层接口代理对象)
		 TbItemCatMapper tbItemCatMapper = applicationContext.getBean(TbItemCatMapper.class);
		//根据parentId查询节点列表
		TbItemCatExample example=new TbItemCatExample();
				//设置查询条件
		cn.e3mall.pojo.TbItemCatExample.Criteria criteria1 = example.createCriteria();
		cn.e3mall.pojo.TbItemCatExample.Criteria criteria2 = criteria1.andParentIdEqualTo(1L);
		List<TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
		System.out.println("criteria1==criteria2"+(criteria1==criteria2));
		System.out.println("criteria1="+criteria1);
		System.out.println("criteria2="+criteria2);
	}
}
