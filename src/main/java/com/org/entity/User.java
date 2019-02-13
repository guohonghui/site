package com.org.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.org.base.DataEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 */
@Data
@TableName("sys_user")
public class User extends DataEntity<User> {

	private static final long serialVersionUID = 7966022079571571635L;

	@ApiModelProperty(value = "登录名")
	private String loginName;

	@ApiModelProperty(value = "昵称")
	private String nickName;

	@ApiModelProperty(value = "密码")
	@JSONField(serialize=false)
	private String password;

	@ApiModelProperty(value = "shiro加密盐")
	@JSONField(serialize=false)
	private String salt;

	@ApiModelProperty(value = "手机号码")
	private String tel;

	@ApiModelProperty(value = "邮箱地址")
	private String email;

	@ApiModelProperty(value = "账户是否锁定")
	private Boolean locked;

	@ApiModelProperty(value = "头像")
	private String icon;

	@TableField(exist=false)
	@ApiModelProperty(value = "角色")
	private Set<Role> roleLists = new HashSet<>();

	@TableField(exist=false)
	@ApiModelProperty(value = "菜单")
	private Set<Menu> menus = new HashSet<>();

}
