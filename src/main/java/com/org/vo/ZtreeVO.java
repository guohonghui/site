package com.org.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Ztree 树
 */
public class ZtreeVO implements Serializable{

	private static final long serialVersionUID = 3523260931626639430L;

	@ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "父id")
	private Long pid;

	@ApiModelProperty(value = "菜单名")
	private String name;

	@ApiModelProperty(value = "url")
	private String url;

	@ApiModelProperty(value = "是否打开")
	private Boolean open =true;

	@ApiModelProperty(value = "是否展开")
	private Boolean isParent;

	@ApiModelProperty(value = "子节点")
	private List<ZtreeVO> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public List<ZtreeVO> getChildren() {
		return children;
	}

	public void setChildren(List<ZtreeVO> children) {
		this.children = children;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}
}
