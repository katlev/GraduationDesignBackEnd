package com.katle.design.service.impl;

import com.katle.design.dao.PermissionMapper;
import com.katle.design.dao.RoleMapper;
import com.katle.design.dao.UserMapper;
import com.katle.design.entities.Permission;
import com.katle.design.entities.Role;
import com.katle.design.entities.User;
import com.katle.design.entities.UserExample;
import com.katle.design.service.ShiroService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 罗惠铎
 * @date 2020/12/7
 */
@Service
public class ShiroServiceImpl implements ShiroService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public User getUser(String usernum) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernumEqualTo(usernum);
        User user = userMapper.selectByExample(userExample).get(0);
        return user;
    }

    @Override
    public Role getRole(Long userId) {
        return roleMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Permission getPermission(Long userId) {
        return permissionMapper.selectByPrimaryKey(userId);
    }
}
