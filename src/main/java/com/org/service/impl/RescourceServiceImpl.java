package com.org.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.org.dao.RescourceDao;
import com.org.entity.Rescource;
import com.org.service.RescourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统资源 服务实现类
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class RescourceServiceImpl extends ServiceImpl<RescourceDao, Rescource> implements RescourceService {

}
