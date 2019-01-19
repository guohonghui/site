package com.org.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.org.base.DataEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统资源
 */
@Data
@TableName("sys_rescource")
public class Rescource extends DataEntity<Rescource> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件名称")
	@TableField("file_name")
	private String fileName;

	@ApiModelProperty(value = "来源")
	private String source;

	@ApiModelProperty(value = "资源网络地址")
	@TableField("web_url")
	private String webUrl;

	@ApiModelProperty(value = "文件标识")
	private String hash;

	@ApiModelProperty(value = "文件大小")
	@TableField("file_size")
	private String fileSize;

	@ApiModelProperty(value = "文件类型")
	@TableField("file_type")
	private String fileType;

	@ApiModelProperty(value = "url")
	@TableField("original_net_url")
	private String originalNetUrl;

	@Override
	public String toString() {
		return "Rescource{" +
			", fileName=" + fileName +
			", source=" + source +
			", webUrl=" + webUrl +
			", hash=" + hash +
			", fileSize=" + fileSize +
			", fileType=" + fileType +
			", originalNetUrl=" + originalNetUrl +
			"}";
	}
}
