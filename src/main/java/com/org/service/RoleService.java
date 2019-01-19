package com.org.service;

import com.baomidou.mybatisplus.service.IService;
import com.org.entity.Menu;
import com.org.entity.Role;

import java.util.List;
import java.util.Set;

/**
 *  服务类
 */
public interface RoleService extends IService<Role> {

    Role saveRole(Role role);

    Role getRoleById(Long id);

    void updateRole(Role role);

    void deleteRole(Role role);

    void saveRoleMenus(Long id, Set<Menu> menuSet);

    void dropRoleMenus(Long id);

    Integer getRoleNameCount(String name);

    List<Role> selectAll();
	
}
