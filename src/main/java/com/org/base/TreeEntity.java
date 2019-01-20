package com.org.base;


import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import java.util.List;

/**
 * 数据Entity类
 */
public abstract class TreeEntity<T extends Model> extends DataEntity<T> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "varchar(64) NULL父id")
    protected Long parentId;

    @ApiModelProperty(value = "节点层次（第一层，第二层，第三层....）")
    protected Integer level;

    @ApiModelProperty(value = "varchar(1000) NULL路径")
    @Length( max = 1000, message = "路径长度必须介于 1 和 1000 之间")
    protected String parentIds;

    @ApiModelProperty(value = "int(11) NULL排序")
    protected Integer sort;

    @ApiModelProperty(value = "子节点")
    @TableField(exist = false)
    protected List<T> children;

    @ApiModelProperty(value = "父树节点")
    @TableField(exist = false)
    protected T parentTree;

    public TreeEntity() {
        super();
        this.sort = 30;
    }

    public TreeEntity(Long id) {
        super(id);
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Length( max = 1000, message = "路径长度必须介于 1 和 1000 之间")
    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }

    public T getParentTree() {
        return parentTree;
    }

    public void setParentTree(T parentTree) {
        this.parentTree = parentTree;
    }

}
