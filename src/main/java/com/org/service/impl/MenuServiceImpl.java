package com.org.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.org.dao.MenuDao;
import com.org.entity.Menu;
import com.org.service.MenuService;
import com.org.vo.ShowMenu;
import com.org.vo.ZtreeVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 *  服务实现类
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {

    @Override
    public List<Menu> selectAllMenus(Map<String,Object> map) {
        return baseMapper.getMenus(map);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void saveOrUpdateMenu(Menu menu) {
        insertOrUpdate(menu);
    }

    @Override
    public int getCountByPermission(String permission) {
        EntityWrapper<Menu> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        wrapper.eq("permission",permission);
        return baseMapper.selectCount(wrapper);
    }

    @Override
    public int getCountByName(String name) {
        EntityWrapper<Menu> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        wrapper.eq("name",name);
        return baseMapper.selectCount(wrapper);
    }

    @Override
    public List<ZtreeVO> showTreeMenus() {
        EntityWrapper<Menu> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        wrapper.eq("is_show",true);
        wrapper.orderBy("sort",false);
        List<Menu> totalMenus = baseMapper.selectList(wrapper);
        List<ZtreeVO> ztreeVOs = Lists.newArrayList();
        return getZTree(null,totalMenus,ztreeVOs);
    }

    @Override
    public List<ShowMenu> getShowMenuByUser(Long id) {
        Map<String,Object> map = Maps.newHashMap();
        map.put("userId",id);
        map.put("parentId",null);
        return baseMapper.selectShowMenuByUser(map);
    }

    /**
     * 递归拉取菜单树的数据
     */
    private  List<ZtreeVO> getZTree(ZtreeVO tree,List<Menu> total,List<ZtreeVO> result){
        Long pid = tree == null?null:tree.getId();
        List<ZtreeVO> childList = Lists.newArrayList();
        for (Menu m : total){
            if(pid == m.getParentId()) {
                ZtreeVO ztreeVO = new ZtreeVO();
                ztreeVO.setId(m.getId());
                ztreeVO.setName(m.getName());
                ztreeVO.setPid(pid);
                childList.add(ztreeVO);
                getZTree(ztreeVO,total,result);
            }
        }
        if(tree != null){
            tree.setChildren(childList);
        }else{
            result = childList;
        }
        return result;
    }

}
