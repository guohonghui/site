package com.org.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.org.base.DataEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 网站配置
 */
@Data
@TableName("sys_site")
public class Site extends DataEntity<Site> {

	private static final long serialVersionUID = -3496778491995539222L;

	@ApiModelProperty(value = "网站名称")
	private String name;

	@ApiModelProperty(value = "当前版本")
	private String version;

	@ApiModelProperty(value = "开发作者")
	private String author;

	@TableField("author_icon")
	@ApiModelProperty(value = "作者头像")
	private String authorIcon;

	@TableField("file_upload_type")
	@ApiModelProperty(value = "文件上传方式")
	private String fileUploadType;

	@ApiModelProperty(value = "微博")
	private String weibo;

	@ApiModelProperty(value = "QQ")
	private String qq;

	@ApiModelProperty(value = "Git")
	private String git;

	@ApiModelProperty(value = "github")
	private String github;

	@ApiModelProperty(value = "手机")
	private String phone;

	@ApiModelProperty(value = "邮箱")
	private String email;

	@ApiModelProperty(value = "地址")
	private String address;

	@ApiModelProperty(value = "网站LOGO")
	private String logo;

	@ApiModelProperty(value = "服务器环境")
	private String server;

	@ApiModelProperty(value = "数据库版本")
	private String database;

	@TableField("max_upload")
	@ApiModelProperty(value = "最大上传限制")
	private Integer maxUpload;

	@ApiModelProperty(value = "关键字")
	private String keywords;

	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "版权信息")
	private String powerby;

	@ApiModelProperty(value = "网站备案号")
	private String record;

	@ApiModelProperty(value = "网站网址")
	private String url;

	@ApiModelProperty(value = "是否开放系统评论")
	private Boolean openMessage = false;

	@ApiModelProperty(value = "是否匿名评论")
	private Boolean isNoName = false;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Site{" +
			", name=" + name +
			", version=" + version +
			", author=" + author +
			", phone=" + phone +
			", email=" + email +
			", fileUploadType=" + fileUploadType +
			", logo=" + logo +
			", server=" + server +
			", database=" + database +
			", maxUpload=" + maxUpload +
			", keywords=" + keywords +
			", description=" + description +
			", powerby=" + powerby +
			", record=" + record +
			"}";
	}
}
