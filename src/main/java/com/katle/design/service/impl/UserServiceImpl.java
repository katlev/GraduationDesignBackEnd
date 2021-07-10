package com.katle.design.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.katle.design.dao.FileMapper;
import com.katle.design.dao.PermissionMapper;
import com.katle.design.dao.RoleMapper;
import com.katle.design.dao.UserMapper;
import com.katle.design.entities.*;
import com.katle.design.service.UserService;
import com.katle.design.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMapper roleMapper;
    @Resource
    private PermissionMapper permissionMapper;
    @Resource
    private FileMapper fileMapper;

    /**
     * 根据学号获取用户
     * @param usernum
     * @return
     */
    @Override
    public User getUserByUsernum(String usernum) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernumEqualTo(usernum);
        try {
            return userMapper.selectByExample(userExample).get(0);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 根据id来获取用户信息
     * @param userId
     * @return
     */
    @Override
    public User getUserByUserId(Long userId){
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        try {
            return userMapper.selectByExample(userExample).get(0);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 获取用户角色
     * @param userId
     * @return
     */
    @Override
    public String getRole(Long userId) {
        return roleMapper.selectByPrimaryKey(userId).getRole();
    }

    /**
     * 获取用户列表
     * @return
     */
    @Override
    public List<User> getUserList() {
        UserExample userExample=new UserExample();
        return userMapper.selectByExample(userExample);
    }

    /**
     * 分页限制
     * @param page
     * @param limit
     * @return
     */
    @Override
    public Map<String,Object> userVoList(int page, int limit) {
        PageHelper.startPage(page,limit);
        UserExample userExample=new UserExample();
        List<User> userList=userMapper.selectByExample(userExample);
        List<UserVO> userVOList=new ArrayList<>();

        for(User user:userList){
            Role role=roleMapper.selectByPrimaryKey(user.getUserId());
            UserVO userVO=new UserVO();

            userVO.setUserId(user.getUserId());
            userVO.setUsername(user.getUsername());
            userVO.setPhoneNumber(user.getUsernum());
            userVO.setRole(role.getRole());

            userVOList.add(userVO);
        }

        PageInfo pageInfo=new PageInfo<>(userList);
        Map<String,Object> map=new HashMap<>();
        map.put("pageInfo",pageInfo);
        map.put("userVOList",userVOList);
        return map;
    }

    /**
     * 文件上传
     * @param path
     * @return
     */
    @Override
    public boolean uploadFile(String path) {
        File file=new File();
        file.setPath(path);
        return fileMapper.insertSelective(file)>0;
    }

    /**
     * 修改密码
     * @param id
     * @param password
     * @return
     */
    @Override
    public User updateUserPwd(Long id, String password) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setPassword(password);
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    /**
     * 修改管理员个人信息
     * @param id
     * @return
     */
    @Override
    public User updateAdminInfo(Long id,String usernum,String username,String password,String position,String college,String avatar) {
        User user = userMapper.selectByPrimaryKey(id);
        user.setUsernum(usernum);
        user.setUsername(username);
        user.setPassword(password);
        user.setPosition(position);
        user.setCollege(college);
        user.setAvatar(avatar);
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    /**
     * 管理员校验
     * @param usernum
     * @return
     */
    @Override
    public boolean checkAdmin(String usernum) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernumEqualTo(usernum);
        User userItem = userMapper.selectByExample(userExample).get(0);

        long userId = userItem.getUserId();

        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria1 = roleExample.createCriteria();
        criteria1.andUserIdEqualTo(userId);
        Role roleItem = roleMapper.selectByExample(roleExample).get(0);

        String role = roleItem.getRole();
        String identity = "administrators";

        return role.equals(identity);
    }

    /**
     * 管理员注册
     * @param usernum
     * @param username
     * @param password
     * @param position
     * @param college
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)//事务回滚
    public boolean adminRegister(String usernum,String username,String password,String position,String college) {
       User user = new User();
       user.setUsernum(usernum);
       user.setUsername(username);
       user.setPassword(password);
       user.setPosition(position);
       user.setCollege(college);
       userMapper.insertSelective(user);

       UserExample userExample = new UserExample();
       UserExample.Criteria criteria = userExample.createCriteria();
       criteria.andUsernumEqualTo(usernum);
       User userItem = userMapper.selectByExample(userExample).get(0);

       Long userId = userItem.getUserId();

        /**
         * 查询已经插入的的自增主键
         */
       Role role=new Role();
       role.setUserId(userId);
       role.setRole("administrators");
       roleMapper.insertSelective(role);

       File file = new File();
       file.setUserId(userId);
       fileMapper.insertSelective(file);

       Permission permission = new Permission();
       permission.setUserId(userId);
       permission.setPermission("study");
       return permissionMapper.insertSelective(permission)>0;

    }

    /**
     * 一张表多值模糊查询
     * @param value
     * @return
     */
    @Override
    public List<User> getUsers(String value) {
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        if(null!=value && !"".equals(value.trim())){
            criteria.andUsernumLike("%"+value+"%");
        }
        if(null!=value && !"".equals(value.trim())){
            criteria.andCollegeLike("%"+value+"%");
        }
        if(null!=value && !"".equals(value.trim())){
            criteria.andMajorLike("%"+value+"%");
        }
        //select * from user where username=zhnagsan or college=lisi;
        /*if(null!=username && !"".equals(username.trim())){
            userExample.or().andUsernumEqualTo("%"+username+"%");
        }*/
        return userMapper.selectByExample(userExample);
    }

    /**
     * 根据学号获取用户角色
     * @param usernum
     * @return
     */
    @Override
    public String getRoleByUsernum(String usernum) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernumEqualTo(usernum);
        User user = userMapper.selectByExample(userExample).get(0);

        Long userId = user.getUserId();

        Role roleItem = roleMapper.selectByPrimaryKey(userId);
        String role = roleItem.getRole();

        return role;
    }

    /**
     * 上传图片
     * @param userId
     * @param avatar
     * @return
     */
    @Override
    public boolean uploadImg(Long userId, String avatar) {
        User user = userMapper.selectByPrimaryKey(userId);
        user.setAvatar(avatar);
        return userMapper.updateByPrimaryKeySelective(user)>0;
    }

    /**
     * 文件导入测试
     * @param user
     * @return
     */
    @Override
    public boolean insert(User user) {
        return userMapper.insertSelective(user)>0;
    }
}
