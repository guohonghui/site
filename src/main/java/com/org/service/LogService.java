package com.org.service;

import com.baomidou.mybatisplus.service.IService;
import com.org.entity.Log;

import java.util.List;

/**
 * 系统日志 服务类
 */
public interface LogService extends IService<Log> {

    List<Integer> selectSelfMonthData();

}
