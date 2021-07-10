package com.katle.design.service;

import com.katle.design.entities.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 根据学号获取用户
     *
     * @param usernum
     * @return
     */
    User getUserByUsernum(String usernum);

    /**
     *根据id查询用户xinix
     * @param userId
     * @return
     */
    User getUserByUserId(Long userId);

    /**
     * 获取用户角色
     *
     * @param userId
     * @return
     */
    String getRole(Long userId);

    /**
     * user列表
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 多表查询分页
     *
     * @return
     */
    Map<String,Object> userVoList(int page, int limit);

    /**
     * 存储文件的路径
     *
     * @param path
     * @return
     */
    boolean uploadFile(String path);

    /**
     * 用户密码修改
     * @param id
     * @param password
     * @return
     */
    User updateUserPwd(Long id,String password);

    /**
     * 管理员信息修改
     * @param id
     * @param password
     * @param usernum
     * @param username
     * @param position
     * @param college
     * @return
     */
    User updateAdminInfo(Long id,String usernum,String username,String password,String position,String college,String avatar);


    /**
     * 管理员校验
     * @param usernum
     * @return
     */
    boolean checkAdmin(String usernum);

    /**
     * 管理员注册
     * @param usernum
     * @param username
     * @param password
     * @param position
     * @param college
     * @return
     */
     boolean adminRegister(String usernum,String username,String password,String position,String college);


    /**
     * 一张表多字段查询
     * @param value
     * @return
     */
      List<User> getUsers(String value);

    /**
     * 根据学号获取用户角色
     * @param usernum
     * @return
     */
      String getRoleByUsernum(String usernum);

    /**
     * 图片上传
     * @param userId
     * @param avatar
     * @return
     */
      boolean uploadImg(Long userId,String avatar);

    /**
     * 文件导入测试
     * @param user
     * @return
     */
    boolean insert(User user);
}
