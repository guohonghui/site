package com.org.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.org.dao.RoleDao;
import com.org.entity.Menu;
import com.org.entity.Role;
import com.org.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 *  服务实现类
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    @Override
    @Transactional
    public Role saveRole(Role role) {
        baseMapper.insert(role);
        baseMapper.saveRoleMenus(role.getId(),role.getMenuSet());
        return role;
    }

    @Override
    public Role getRoleById(Long id) {
        Role role = baseMapper.selectRoleById(id);
        return role;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void updateRole(Role role) {
        baseMapper.updateById(role);
        baseMapper.dropRoleMenus(role.getId());
        baseMapper.saveRoleMenus(role.getId(),role.getMenuSet());
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteRole(Role role) {
        role.setDelFlag(true);
        baseMapper.updateById(role);
        baseMapper.dropRoleMenus(role.getId());
        baseMapper.dropRoleUsers(role.getId());
    }

    @Override
    public Integer getRoleNameCount(String name) {
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper.eq("name",name);
        return baseMapper.selectCount(wrapper);
    }

    @Override
    public List<Role> selectAll() {
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper.eq("del_flag",false);
        List<Role> roleList = baseMapper.selectList(wrapper);
        return roleList;
    }
}
