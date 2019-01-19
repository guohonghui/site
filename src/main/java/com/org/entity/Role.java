package com.org.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.org.base.DataEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Set;

/**
 * 角色
 */
@Data
@TableName("sys_role")
public class Role extends DataEntity<Role> {

	private static final long serialVersionUID = -4975289201832846860L;

	@ApiModelProperty(value = "角色名称")
	private String name;

	@ApiModelProperty(value = "菜单")
	@TableField(exist = false)
	private Set<Menu> menuSet;

	@ApiModelProperty(value = "用户")
	@TableField(exist = false)
	private Set<User> userSet;

}
