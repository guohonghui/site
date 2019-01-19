package com.org.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.org.dao.UserDao;
import com.org.entity.Role;
import com.org.entity.User;
import com.org.service.UserService;
import com.org.utils.ToolUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *  服务实现类
 */
@Service("userService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

	@Override
	public User findUserByLoginName(String name) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		map.put("loginName", name);
		User u = baseMapper.selectUserByMap(map);
		return u;
	}


	@Override
	public User findUserById(Long id) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		return baseMapper.selectUserByMap(map);
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public User saveUser(User user) {
		ToolUtil.entryptPassword(user);
		user.setLocked(false);
		baseMapper.insert(user);
		//保存用户角色关系
		this.saveUserRoles(user.getId(),user.getRoleLists());
		return findUserById(user.getId());
	}

	@Override
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public User updateUser(User user) {
		baseMapper.updateById(user);
		//先解除用户跟角色的关系
		this.dropUserRolesByUserId(user.getId());
		this.saveUserRoles(user.getId(),user.getRoleLists());
		return user;
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	public void saveUserRoles(Long id, Set<Role> roleSet) {
		baseMapper.saveUserRoles(id,roleSet);
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	public void dropUserRolesByUserId(Long id) {
		baseMapper.dropUserRolesByUserId(id);
	}

	@Override
	public int userCount(String param) {
		EntityWrapper<User> wrapper = new EntityWrapper<>();
		wrapper.eq("login_name",param).or().eq("email",param).or().eq("tel",param);
		int count = baseMapper.selectCount(wrapper);
		return count;
	}

	@Transactional(readOnly = false, rollbackFor = Exception.class)
	@Override
	public void deleteUser(User user) {
		user.setDelFlag(true);
		user.updateById();
	}

}
