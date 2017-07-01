package cn.e3mall.pojo;

import java.io.Serializable;
/**
 * 创建一个pojo来描述tree的节点信息
 * @author gys
 *
 */
public class EasyUITreeNode implements Serializable {
	private Long id;//id[父节点id]
	private String text;//text[显示节点文本],比如父文件夹后缀文字描述
	private String state;//state[是否还有子节点 ] closed 有   open 没有子节点
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "EasyUITreeNode [id=" + id + ", text=" + text + ", state=" + state + "]";
	}
	
}
