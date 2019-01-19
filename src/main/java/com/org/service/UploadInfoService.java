package com.org.service;

import com.baomidou.mybatisplus.service.IService;
import com.org.entity.UploadInfo;

/**
 * 文件上传配置 服务类
 */
public interface UploadInfoService extends IService<UploadInfo> {

    UploadInfo getOneInfo();

    void updateInfo(UploadInfo uploadInfo);

}
