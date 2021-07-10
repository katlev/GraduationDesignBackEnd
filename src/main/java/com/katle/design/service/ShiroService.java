package com.katle.design.service;

import com.katle.design.entities.Permission;
import com.katle.design.entities.Role;
import com.katle.design.entities.User;

/**
 * @author 罗惠铎
 * @date 2020/12/7
 */
public interface ShiroService {
    /**
     * 获取一个用户
     *
     * @param usernum
     * @return User
     */
    User getUser(String usernum);

    /**
     * 获取用户的角色
     *
     * @param userId
     * @return Role
     */
    Role getRole(Long userId);

    /**
     * 获取用户的权限
     *
     * @param userId
     * @return Permission
     */
    Permission getPermission(Long userId);


}
