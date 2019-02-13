package com.org.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Ztree 树
 */
@Data
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

}
