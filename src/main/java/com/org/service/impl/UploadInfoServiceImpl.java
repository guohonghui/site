package com.org.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.org.dao.UploadInfoDao;
import com.org.entity.UploadInfo;
import com.org.service.UploadInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文件上传配置 服务实现类
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UploadInfoServiceImpl extends ServiceImpl<UploadInfoDao, UploadInfo> implements UploadInfoService {

    @Override
    public UploadInfo getOneInfo() {
        EntityWrapper<UploadInfo> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        return selectOne(wrapper);
    }

    @Override
    public void updateInfo(UploadInfo uploadInfo) {
        updateById(uploadInfo);
    }
}
