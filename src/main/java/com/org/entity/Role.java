package com.org.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.org.base.DataEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Set;

/**
 * 角色
 */
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Menu> getMenuSet() {
		return menuSet;
	}

	public void setMenuSet(Set<Menu> menuSet) {
		this.menuSet = menuSet;
	}

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

}
