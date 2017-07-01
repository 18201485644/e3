package cn.e3mall.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 商品分类选择节点类
 * @author gys
 *
 */
public class TbItemCat implements Serializable{
    private Long id;//id[类目id]

    private Long parentId;//parent_id[父类目ID=0时，代表的是一级的类目]

    private String name;//name[类目名称]

    private Integer status;//status[状态。可选值:1(正常),2(删除)]
    //sort_order[排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数]
    //叶子节点子节点
    private Integer sortOrder;

    private Boolean isParent;//is_parent[该类目是否为父类目，1为true，0为false,即是否有子节点]

    private Date created;//created[创建时间]

    private Date updated;//updated[更新时间]

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}