package cn.e3mall.pojo;

import java.io.Serializable;
import java.util.List;
/**
 * 分页信息类
 * @author gys
 *
 */
public class EasyUIDataGridResult implements Serializable {
	private Integer total;//total[总数据]
	private List<?> rows;//rows[页信息集合]
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public EasyUIDataGridResult(Integer total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public EasyUIDataGridResult(Long total, List<?> rows) {
		super();
		this.total = total.intValue();
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "EasyUIDataGridResult [total=" + total + ", rows=" + rows + "]";
	}
	
	
}
