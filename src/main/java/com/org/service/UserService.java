package com.org.service;

import com.baomidou.mybatisplus.service.IService;
import com.org.entity.Role;
import com.org.entity.User;

import java.util.Map;
import java.util.Set;

/**
 *  服务类
 */
public interface UserService extends IService<User> {

	User findUserByLoginName(String name);

	User findUserById(Long id);

	User saveUser(User user);

	User updateUser(User user);

	void saveUserRoles(Long id, Set<Role> roleSet);

	void dropUserRolesByUserId(Long id);

	int userCount(String param);

	void deleteUser(User user);

}
