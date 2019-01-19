package com.org.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.org.entity.Menu;
import com.org.vo.ShowMenu;

import java.util.List;
import java.util.Map;

/**
 *  Mapper 接口
 */
public interface MenuDao extends BaseMapper<Menu> {

    List<Menu> showAllMenusList(Map map);

    List<Menu> getMenus(Map map);

    List<ShowMenu> selectShowMenuByUser(Map<String, Object> map);
}