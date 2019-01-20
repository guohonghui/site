package com.org.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.org.base.DataEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 */
@TableName("sys_user")
public class User extends DataEntity<User> {

	private static final long serialVersionUID = 7966022079571571635L;

	@TableField("login_name")
	@ApiModelProperty(value = "登录名")
	private String loginName;

	@TableField(value = "nick_name",strategy= FieldStrategy.IGNORED)
	@ApiModelProperty(value = "昵称")
	private String nickName;

	@ApiModelProperty(value = "密码")
	@JSONField(serialize=false)
	private String password;

	@ApiModelProperty(value = "shiro加密盐")
	@JSONField(serialize=false)
	private String salt;

	@TableField(strategy= FieldStrategy.IGNORED)
	@ApiModelProperty(value = "手机号码")
	private String tel;

	@TableField(strategy= FieldStrategy.IGNORED)
	@ApiModelProperty(value = "邮箱地址")
	private String email;

	@ApiModelProperty(value = "账户是否锁定")
	private Boolean locked;

	@TableField(strategy= FieldStrategy.IGNORED)
	@ApiModelProperty(value = "头像")
	private String icon;

	@TableField(exist=false)
	@ApiModelProperty(value = "角色")
	private Set<Role> roleLists = new HashSet<>();

	@TableField(exist=false)
	@ApiModelProperty(value = "菜单")
	private Set<Menu> menus = new HashSet<>();

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@JSONField(serialize=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@JSONField(serialize=false)
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Set<Role> getRoleLists() {
		return roleLists;
	}

	public void setRoleLists(Set<Role> roleLists) {
		this.roleLists = roleLists;
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

}
