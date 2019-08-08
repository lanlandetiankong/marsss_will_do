package com.marsss.marsss_will_do.service.user;

import com.marsss.marsss_will_do.common.base.service.MyBaseService;
import com.marsss.marsss_will_do.entity.user.UserAccountInfo;


public interface UserAccountInfoService extends MyBaseService {
    /**
     * 返回一个待创建的 用户明细信息
     * @param userAccountInfo
     * @return
     */
    UserAccountInfo doGetPreAddUserAccountInfoVo(UserAccountInfo userAccountInfo) ;
    UserAccountInfo doGetPreAddUserAccountInfoVo() ;
}
