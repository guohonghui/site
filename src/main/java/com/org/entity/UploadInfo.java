package com.org.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.org.base.DataEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文件上传配置
 */
@Data
@TableName("upload_info")
public class UploadInfo extends DataEntity<UploadInfo> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "本地window系统上传路径")
	private String localWindowUrl;

	@ApiModelProperty(value = "本地LINUX系统上传路径")
	private String localLinuxUrl;

	@ApiModelProperty(value = "七牛前缀路径")
	private String qiniuBasePath;

	@ApiModelProperty(value = "七牛bucket的目录名称")
	private String qiniuBucketName;

	@ApiModelProperty(value = "七牛文件存储目录")
	private String qiniuDir;

	@ApiModelProperty(value = "七牛qiniuAccess值")
	private String qiniuAccessKey;

	@ApiModelProperty(value = "七牛qiniuKey的值")
	private String qiniuSecretKey;

	@ApiModelProperty(value = "七牛上传测试结果")
	private Boolean qiniuTestAccess;

	@ApiModelProperty(value = "阿里云前缀路径")
	private String ossBasePath;

	@ApiModelProperty(value = "阿里云bucket的目录名称")
	private String ossBucketName;

	@ApiModelProperty(value = "阿里云文件上传目录")
	private String ossDir;

	@ApiModelProperty(value = "阿里云ACCESS_KEY_ID值")
	private String ossKeyId;

	@ApiModelProperty(value = "阿里云ACCESS_KEY_SECRET")
	private String ossKeySecret;

	@ApiModelProperty(value = "阿里云ENDPOINT值")
	private String ossEndpoint;

	@ApiModelProperty(value = "阿里云上传测试结果")
	private Boolean ossTestAccess;

	@Override
	public String toString() {
		return "UploadInfo{" +
				", localWindowUrl=" + localWindowUrl +
				", localLinuxUrl=" + localLinuxUrl +
				", qiniuBasePath=" + qiniuBasePath +
				", qiniuBucketName=" + qiniuBucketName +
				", qiniuDir=" + qiniuDir +
				", qiniuAccessKey=" + qiniuAccessKey +
				", qiniuSecretKey=" + qiniuSecretKey +
				", ossBasePath=" + ossBasePath +
				", ossBucketName=" + ossBucketName +
				", ossDir=" + ossDir +
				", ossKeyId=" + ossKeyId +
				", ossKeySecret=" + ossKeySecret +
				"}";
	}
}
