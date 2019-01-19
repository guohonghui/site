package com.org.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.org.annotation.SysLog;
import com.org.entity.Role;
import com.org.entity.User;
import com.org.service.MenuService;
import com.org.service.RoleService;
import com.org.service.UserService;
import com.org.utils.*;
import com.org.vo.ShowMenu;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Simple on 2018/11/21.
 */
@Slf4j
@Controller
@RequestMapping("admin/system/user")
public class UserConteroller {


    @Autowired
    protected UserService userService;

    @Autowired
    protected MenuService menuService;

    @Autowired
    protected RoleService roleService;

    /**
     * 用户列表
     * @param page
     * @param limit
     * @param request
     * @return
     */
    @RequiresPermissions("sys:user:list")
    @PostMapping("list")
    @ResponseBody
    public LayerData<User> list(@RequestParam(value = "page",defaultValue = "1")Integer page,
                                @RequestParam(value = "limit",defaultValue = "10")Integer limit,
                                HttpServletRequest request){
        Map map = WebUtils.getParametersStartingWith(request, "s_");
        LayerData<User> userLayerData = new LayerData<>();
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<>();
        if(!map.isEmpty()){
            String keys = (String) map.get("key");
            if(StringUtils.isNotBlank(keys)) {
                userEntityWrapper.like("login_name", keys).or().like("tel", keys).or().like("email", keys);
            }
        }
        Page<User> userPage = userService.selectPage(new Page<>(page,limit),userEntityWrapper);
        userLayerData.setCount(userPage.getTotal());
        userLayerData.setData(userPage.getRecords());
        return  userLayerData;
    }

    @GetMapping("add")
    public String add(Model model){
        List<Role> roleList = roleService.selectAll();
        model.addAttribute("roleList",roleList);
        return "admin/system/user/add";
    }

    @PostMapping("add")
    @ResponseBody
    @SysLog("保存新增系统用户数据")
    public RestResponse add(@RequestBody User user){
        if(StringUtils.isBlank(user.getLoginName())){
            return RestResponse.failure("登录名不能为空");
        }
        if(user.getRoleLists() == null || user.getRoleLists().size() == 0){
            return  RestResponse.failure("用户角色至少选择一个");
        }
        if (!"root".equals(user.getLoginName()) || !"admin".equals(user.getLoginName())){
            return RestResponse.failure("不允许非管理员用户使用"+user.getLoginName()+"登录名");
        }
        if(userService.userCount(user.getLoginName())>0){
            return RestResponse.failure("登录名称已经存在");
        }
        if(StringUtils.isNotBlank(user.getEmail())){
            if(userService.userCount(user.getEmail())>0){
                return RestResponse.failure("该邮箱已被使用");
            }
        }
        if(StringUtils.isNoneBlank(user.getTel())){
            if(userService.userCount(user.getTel())>0){
                return RestResponse.failure("该手机号已被绑定");
            }
        }
        user.setPassword(Constants.DEFAULT_PASSWORD);
        userService.saveUser(user);
        if(user.getId() == null || user.getId() == 0){
            return RestResponse.failure("保存用户信息出错");
        }
        return RestResponse.success();
    }

    @GetMapping("edit")
    public String edit(Long id,Model model){
        User user = userService.findUserById(id);
        List<Long> roleIdList = new ArrayList<>();
        if(user != null) {
            Set<Role> roleSet = user.getRoleLists();
            if (roleSet != null && roleSet.size() > 0) {
                for (Role r : roleSet) {
                    roleIdList.add(r.getId());
                }
            }
        }
        List<Role> roleList = roleService.selectAll();
        model.addAttribute("localuser",user);
        model.addAttribute("roleIds",roleIdList);
        model.addAttribute("roleList",roleList);
        return "admin/system/user/edit";
    }

    @PostMapping("edit")
    @ResponseBody
    @SysLog("保存系统用户编辑数据")
    public RestResponse edit(@RequestBody User user){
        if(user.getId() == 0 || user.getId() == null){
            return RestResponse.failure("用户ID不能为空");
        }
        if(StringUtils.isBlank(user.getLoginName())){
            return RestResponse.failure("登录名不能为空");
        }
        if(user.getRoleLists() == null || user.getRoleLists().size() == 0){
            return  RestResponse.failure("用户角色至少选择一个");
        }
        if (!"admin".equals(user.getLoginName())){
            return RestResponse.failure("超级管理员不允许修改登录名");
        }
        User oldUser = userService.findUserById(user.getId());
        if(StringUtils.isNotBlank(user.getEmail())){
            if(!user.getEmail().equals(oldUser.getEmail())){
                if(userService.userCount(user.getEmail())>0){
                    return RestResponse.failure("该邮箱已被使用");
                }
            }
        }
        if(StringUtils.isNotBlank(user.getLoginName())){
            if(!user.getLoginName().equals(oldUser.getLoginName())) {
                if (userService.userCount(user.getLoginName()) > 0) {
                    return RestResponse.failure("该登录名已存在");
                }
            }
        }
        if(StringUtils.isNotBlank(user.getTel())){
            if(!user.getTel().equals(oldUser.getTel())) {
                if (userService.userCount(user.getTel()) > 0) {
                    return RestResponse.failure("该手机号已经被绑定");
                }
            }
        }
        user.setIcon(oldUser.getIcon());
        userService.updateUser(user);
        return RestResponse.success();
    }

    @PostMapping("delete")
    @ResponseBody
    @SysLog("删除系统用户数据(单个)")
    public RestResponse delete(@RequestParam(value = "id",required = false)Long id){
        if(id == null || id == 0 || id == 1){
            return RestResponse.failure("参数错误");
        }
        User user = userService.findUserById(id);
        if(user == null){
            return RestResponse.failure("用户不存在");
        }
        if ("admin".equals(user.getLoginName())){
            return RestResponse.failure("超级管理员不允许删除");
        }
        userService.deleteUser(user);
        return RestResponse.success();
    }

    @PostMapping("deleteSome")
    @ResponseBody
    @SysLog("删除系统用户数据(多个)")
    public RestResponse deleteSome(@RequestBody List<User> users){
        if(users == null || users.size()==0){
            return RestResponse.failure("请选择需要删除的用户");
        }
        for (User u : users){
            if(u.getId() == 1){
                return RestResponse.failure("不能删除超级管理员");
            }else{
                userService.deleteUser(u);
            }
        }
        return RestResponse.success();
    }

    /***
     * 获得用户所拥有的菜单列表
     * @return
     */
    @GetMapping("getUserMenu")
    @ResponseBody
    public List<ShowMenu> getUserMenu(){
        Long userId = ShiroUtils.id();
        List<ShowMenu> list = menuService.getShowMenuByUser(userId);
        return list;
    }


    @PostMapping("saveUserinfo")
    @SysLog("系统用户个人信息修改")
    @ResponseBody
    public RestResponse saveUserInfo(User user){
        if(user.getId() == 0 || user.getId() == null){
            return RestResponse.failure("用户ID不能为空");
        }
        if(StringUtils.isBlank(user.getLoginName())){
            return RestResponse.failure("登录名不能为空");
        }
        User oldUser = userService.findUserById(user.getId());
        if(StringUtils.isNotBlank(user.getEmail())){
            if(!user.getEmail().equals(oldUser.getEmail())){
                if(userService.userCount(user.getEmail())>0){
                    return RestResponse.failure("该邮箱已被使用");
                }
            }
        }
        if(StringUtils.isNotBlank(user.getTel())){
            if(!user.getTel().equals(oldUser.getTel())) {
                if (userService.userCount(user.getTel()) > 0) {
                    return RestResponse.failure("该手机号已经被绑定");
                }
            }
        }
        user.setRoleLists(oldUser.getRoleLists());
        userService.updateUser(user);
        return RestResponse.success();
    }


    @RequiresPermissions("sys:user:changePassword")
    @PostMapping("changePassword")
    @SysLog("用户修改密码")
    @ResponseBody
    public RestResponse changePassword(@RequestParam(value = "oldPwd",required = false)String oldPwd,
                                       @RequestParam(value = "newPwd",required = false)String newPwd,
                                       @RequestParam(value = "confirmPwd",required = false)String confirmPwd){

        if (newPwd.equals(oldPwd)){
            return RestResponse.failure("新密码不能和旧密码设置一样");
        }
        if(StringUtils.isBlank(oldPwd)){
            return RestResponse.failure("旧密码不能为空");
        }
        if(StringUtils.isBlank(newPwd)){
            return RestResponse.failure("新密码不能为空");
        }
        if(StringUtils.isBlank(confirmPwd)){
            return RestResponse.failure("确认密码不能为空");
        }
        if(!confirmPwd.equals(newPwd)){
            return RestResponse.failure("确认密码与新密码不一致");
        }
        User user = userService.findUserById(ShiroUtils.id());

        //旧密码不能为空
        String pw = ToolUtil.entryptPassword(oldPwd,user.getSalt()).split(",")[0];
        if(!user.getPassword().equals(pw)){
            return RestResponse.failure("旧密码错误");
        }
        user.setPassword(newPwd);
        ToolUtil.entryptPassword(user);
        userService.updateUser(user);
        return RestResponse.success();
    }

}
