package com.org.service;

import com.baomidou.mybatisplus.service.IService;
import com.org.entity.Menu;
import com.org.vo.ShowMenu;
import com.org.vo.ZtreeVO;

import java.util.List;
import java.util.Map;

/**
 *  服务类
 */
public interface MenuService extends IService<Menu> {

    List<Menu> selectAllMenus(Map<String, Object> map);

    List<ZtreeVO> showTreeMenus();

    List<ShowMenu> getShowMenuByUser(Long id);

    void saveOrUpdateMenu(Menu menu);

    int getCountByPermission(String permission);

    int getCountByName(String name);

}
