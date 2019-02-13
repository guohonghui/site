package com.org.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.org.base.DataEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统日志
 */
@Data
@TableName("sys_log")
public class Log extends DataEntity<Log> {

	private static final long serialVersionUID = -4204469594484464436L;

	@ApiModelProperty(value = "请求类型")
	private String type;

	@ApiModelProperty(value = "日志标题")
	private String title;

	@ApiModelProperty(value = "操作IP地址")
	private String remoteAddr;

	@ApiModelProperty(value = "操作用户昵称")
	private String username;

	@ApiModelProperty(value = "请求URI")
	private String requestUri;

	@ApiModelProperty(value = "操作方式")
	private String httpMethod;

	@ApiModelProperty(value = "请求类型.方法")
	private String classMethod;

	@ApiModelProperty(value = "操作提交的数据")
	private String params;

	@ApiModelProperty(value = "sessionId")
	private String sessionId;

	@ApiModelProperty(value = "返回内容")
	private String response;

	@ApiModelProperty(value = "方法执行时间")
	private Long useTime;

	@ApiModelProperty(value = "浏览器信息")
	private String browser;

	@ApiModelProperty(value = "地区")
	private String area;

	@ApiModelProperty(value = "省")
	private String province;

	@ApiModelProperty(value = "市")
	private String city;

	@ApiModelProperty(value = "网络服务提供商")
	private String isp;

	@ApiModelProperty(value = "异常信息")
	private String exception;

	@Override
	public String toString() {
		return "Log{" +
				", type=" + type +
				", title=" + title +
				", remoteAddr=" + remoteAddr +
				", username=" + username +
				", requestUri=" + requestUri +
				", httpMethod=" + httpMethod +
				", classMethod=" + classMethod +
				", params=" + params +
				", sessionId=" + sessionId +
				", response=" + response +
				", useTime=" + useTime +
				", browser=" + browser +
				", area=" + area +
				", province=" + province +
				", city=" + city +
				", isp=" + isp +
				", exception=" + exception +
				"}";
	}
}
