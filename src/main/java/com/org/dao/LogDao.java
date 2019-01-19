package com.org.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.org.entity.Log;

import java.util.List;
import java.util.Map;

/**
 * 系统日志 Mapper 接口
 */
public interface LogDao extends BaseMapper<Log> {

    List<Map> selectSelfMonthData();
}
