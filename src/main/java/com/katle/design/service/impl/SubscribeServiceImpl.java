package com.katle.design.service.impl;

import com.katle.design.dao.OpenidMapper;
import com.katle.design.dao.UserMapper;
import com.katle.design.entities.Openid;
import com.katle.design.service.SubscribeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SubscribeServiceImpl implements SubscribeService {
    @Resource
    private OpenidMapper openidMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户userId上传用户唯一标识openID
     * @param userId
     * @return
     */
    @Override
    public boolean uploadOpenId(Long userId,String openId) {
        Openid openid = openidMapper.selectByPrimaryKey(userId);
        openid.setOpenId(openId);
        return openidMapper.updateByPrimaryKeySelective(openid)>0;
    }

    /**
     * 根据用户userId获取用户唯一标识openID
     * @param userId
     * @return
     */
    @Override
    public Openid getOpenId(Long userId) {
        Openid openid = openidMapper.selectByPrimaryKey(userId);
        return openid;
    }
}
