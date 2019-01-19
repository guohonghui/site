package com.org.controller;

import com.org.annotation.SysLog;
import com.org.entity.User;
import com.org.service.UserService;
import com.org.utils.ShiroUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统页面配置
 * @author Simple
 * 2018-12-27 21:35:11
 */
@Slf4j
@Controller
public class SystemController {

    @Autowired
    protected UserService userService;


    @GetMapping("login")
    @ApiOperation(value = "登录跳转页")
    public String login(HttpServletRequest request) {
        log.info("跳到这边的路径为:"+request.getRequestURI());
        Subject s = SecurityUtils.getSubject();
        log.info("是否记住登录--->"+s.isRemembered()+"<-----是否有权限登录----->"+s.isAuthenticated()+"<----");
        //判断是否有权限登录，如果没有权限则跳回到login登陆页面
        if(s.isAuthenticated()){
            return "redirect:index";
        }else {
            return "login";
        }
    }

    @GetMapping("index")
    @ApiOperation(value = "index首页")
    public String showView(){
        return "index";
    }


    @GetMapping(value = "")
    @ApiOperation(value = "空地址请求")
    public String index() {
        log.info("这是空地址在请求路径");
        Subject s = SecurityUtils.getSubject();
        return s.isAuthenticated() ? "redirect:index" : "login";
    }

    @GetMapping("systemLogout")
    @SysLog("退出系统")
    @ApiOperation(value = "退出系统")
    public String logOut(){
        SecurityUtils.getSubject().logout();
        return "redirect:/login";
    }

    @GetMapping("main")
    @ApiOperation(value = "main主页")
    public String main(Model model){
       /* Map map = userService.selectUserMenuCount();
        User user = userService.findUserById(MySysUser.id());
        Set<Menu> menus = user.getMenus();
        java.util.List<Menu> showMenus = Lists.newArrayList();
        if(menus != null && menus.size()>0){
            for (Menu menu : menus){
                if(StringUtils.isNotBlank(menu.getHref())){
                    Long result = (Long)map.get(menu.getPermission());
                    if(result != null){
                        menu.setDataCount(result.intValue());
                        showMenus.add(menu);
                    }
                }
            }
        }
        showMenus.sort(new MenuComparator());
        model.addAttribute("userMenu",showMenus);*/
        return "main";
    }

    @GetMapping("userinfo")
    @ApiOperation(value = "个人资料")
    public String toEditMyInfo(Model model){
        Long userId = ShiroUtils.id();
        User user = userService.findUserById(userId);
        model.addAttribute("userinfo",user);
        model.addAttribute("userRole",user.getRoleLists());
        return "admin/system/user/userInfo";
    }

    @GetMapping("changePassword")
    @ApiOperation(value = "修改密码")
    public String changePassword(){
        return "admin/system/user/changePassword";
    }

    @GetMapping("admin/system/user/list")
    @SysLog("跳转系统用户列表页面")
    public String userList(){
        return "admin/system/user/list";
    }

    @GetMapping("admin/system/role/list")
    @SysLog("跳转角色列表页面")
    public String roleList(){
        return "admin/system/role/list";
    }

    @GetMapping("admin/system/menu/list")
    @SysLog("跳转菜单列表")
    public String menuList(){
        return "admin/system/menu/list";
    }

}
