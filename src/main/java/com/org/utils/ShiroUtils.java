package com.org.utils;

import com.org.realm.AuthRealm.ShiroUser;
import org.apache.shiro.SecurityUtils;

/**
 * Created by Simple on 2018-12-28 15:07:29.
 */
public class ShiroUtils {
    /**
     * 取出Shiro中的当前用户LoginName.
     */
    public static String icon() {
        return ShiroUser().getIcon();
    }

    public static Long id() {
        return ShiroUser().getId();
    }

    public static String loginName() {
        return ShiroUser().getloginName();
    }

    public static String nickName(){
        return ShiroUser().getNickName();
    }

    public static ShiroUser ShiroUser() {
        ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
        return user;
    }
}
