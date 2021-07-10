package com.katle.design.service;

import com.katle.design.entities.Openid;
import org.springframework.stereotype.Service;


public interface SubscribeService {
    /**
     * 根据用户userId上传用户唯一标识openID
     * @param userId
     * @return
     */
    boolean uploadOpenId(Long userId,String openId);

    /**
     * 根据用户userId获取用户唯一标识openID
     * @param userId
     * @return
     */
    Openid getOpenId(Long userId);
}
