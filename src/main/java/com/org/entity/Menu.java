package com.org.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.org.base.TreeEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 权限菜单
 */
@Data
@TableName("sys_menu")
public class Menu extends TreeEntity<Menu> {

	private static final long serialVersionUID = -6560282495253224879L;

	@ApiModelProperty(value = "菜单名")
	private String name;

	@TableField(strategy= FieldStrategy.IGNORED)
	@ApiModelProperty(value = "链接地址")
	private String href;

	@TableField(strategy= FieldStrategy.IGNORED)
    @ApiModelProperty(value = "打开方式")
	private String target;

	@TableField(value="is_show",strategy= FieldStrategy.IGNORED)
	@ApiModelProperty(value = "是否显示")
	private Boolean isShow;

	@TableField(strategy= FieldStrategy.IGNORED)
	@ApiModelProperty(value = "权限标识")
	private String permission;

	@TableField(exist = false)
	@ApiModelProperty(value = "数量")
	private Integer dataCount;

}
