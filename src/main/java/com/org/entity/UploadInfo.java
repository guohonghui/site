package com.org.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
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
	@TableField(value = "local_window_url")
	private String localWindowUrl;

	@ApiModelProperty(value = "本地LINUX系统上传路径")
	@TableField(value = "local_linux_url")
	private String localLinuxUrl;

	@ApiModelProperty(value = "七牛前缀路径")
	@TableField(value = "qiniu_base_path")
	private String qiniuBasePath;

	@ApiModelProperty(value = "七牛bucket的目录名称")
	@TableField(value = "qiniu_bucket_name")
	private String qiniuBucketName;

	@ApiModelProperty(value = "七牛文件存储目录")
	@TableField(value = "qiniu_dir",strategy= FieldStrategy.IGNORED)
	private String qiniuDir;

	@ApiModelProperty(value = "七牛qiniuAccess值")
	@TableField(value = "qiniu_access_key")
	private String qiniuAccessKey;

	@ApiModelProperty(value = "七牛qiniuKey的值")
	@TableField(value = "qiniu_secret_key")
	private String qiniuSecretKey;

	@ApiModelProperty(value = "七牛上传测试结果")
	@TableField("qiniu_test_access")
	private Boolean qiniuTestAccess;

	@ApiModelProperty(value = "阿里云前缀路径")
	@TableField(value = "oss_base_path")
	private String ossBasePath;

	@ApiModelProperty(value = "阿里云bucket的目录名称")
	@TableField(value = "oss_bucket_name")
	private String ossBucketName;

	@ApiModelProperty(value = "阿里云文件上传目录")
	@TableField(value = "oss_dir",strategy= FieldStrategy.IGNORED)
	private String ossDir;

	@ApiModelProperty(value = "阿里云ACCESS_KEY_ID值")
	@TableField(value = "oss_key_id")
	private String ossKeyId;

	@ApiModelProperty(value = "阿里云ACCESS_KEY_SECRET")
	@TableField(value = "oss_key_secret")
	private String ossKeySecret;

	@ApiModelProperty(value = "阿里云ENDPOINT值")
	@TableField(value = "oss_endpoint")
	private String ossEndpoint;

	@ApiModelProperty(value = "阿里云上传测试结果")
	@TableField(value = "oss_test_access")
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
