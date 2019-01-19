package com.org.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.org.entity.Menu;
import com.org.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 *  Mapper 接口
 */
public interface RoleDao extends BaseMapper<Role> {

    Role selectRoleById(@Param("id") Long id);

    void saveRoleMenus(@Param("roleId") Long id, @Param("menus") Set<Menu> menus);

    void dropRoleMenus(@Param("roleId") Long roleId);

    void dropRoleUsers(@Param("roleId") Long roleId);
}