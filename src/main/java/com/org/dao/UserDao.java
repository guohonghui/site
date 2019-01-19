package com.org.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.org.entity.Role;
import com.org.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.Set;

/**
 *  Mapper 接口
 */
public interface UserDao extends BaseMapper<User> {

	User selectUserByMap(Map<String, Object> map);

	void saveUserRoles(@Param("userId") Long id, @Param("roleIds") Set<Role> roles);

	void dropUserRolesByUserId(@Param("userId") Long userId);

}