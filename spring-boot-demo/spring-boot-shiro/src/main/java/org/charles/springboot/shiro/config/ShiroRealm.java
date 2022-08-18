package org.charles.springboot.shiro.config;


import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.charles.springboot.shiro.pojo.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class ShiroRealm extends AuthorizingRealm
{
    private final Map<String, User> users = new HashMap<>();

    public ShiroRealm() {
        User u1 = new User();
        u1.setId(1);
        u1.setUsername("charles");
        u1.setPassword("123456");
        users.put("charles", u1);
        User u2 = new User();
        u2.setId(2);
        u2.setUsername("admin");
        u2.setPassword("123456");
        users.put("admin", u2);
    }

    /**
     *
     * 正常，应该在这里，根据用户名去数据库中查询用户的角色
     *
     * 在这个方法中，返回用户的角色/权限
     * @param principals 这个参数中保存着用户的登录信息
     * @return 返回值就是用户的角色/权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //创建角色集合
        Set<String> roles = new HashSet<>();
        //获取登录用户名
        String username = (String) principals.getPrimaryPrincipal();
        if ("charles".equals(username)) {
            roles.add("admin");
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 核心的方法就是这个
     * <p>
     * 这个方法就干一件事：根据用户输入的用户名去数据库查询用户信息并返回
     *
     * @param token 参数中包含了用户登录时输入的用户名密码等信息
     * @return 返回值是从数据库中查询到的用户信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = usernamePasswordToken.getUsername();
        User fromDB = users.get(username);
        if (fromDB == null) {
            throw new UnknownAccountException("用户名输入错误");
        }
        return new SimpleAuthenticationInfo(fromDB.getUsername(), fromDB.getPassword(), getName());
    }
}
