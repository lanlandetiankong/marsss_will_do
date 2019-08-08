package com.marsss.marsss_will_do.service.user;

<<<<<<< HEAD
=======
import com.marsss.marsss_will_do.common.base.service.MyBaseServiceImpl;
>>>>>>> temp
import com.marsss.marsss_will_do.common.enums.user.UserAccountInfoStateEnum;
import com.marsss.marsss_will_do.entity.user.UserAccountInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
<<<<<<< HEAD
public class UserAccountInfoServiceImpl implements UserAccountInfoService {
=======
public class UserAccountInfoServiceImpl extends MyBaseServiceImpl implements UserAccountInfoService {
>>>>>>> temp

    private Logger logger = LoggerFactory.getLogger(UserAccountInfoServiceImpl.class);

    @Override
    public UserAccountInfo doGetPreAddUserAccountInfoVo(UserAccountInfo userAccountInfo) {
        userAccountInfo = userAccountInfo != null ? userAccountInfo : new UserAccountInfo() ;
        userAccountInfo.setState(UserAccountInfoStateEnum.ENABLED.getValue());
        return userAccountInfo;
    }

    @Override
    public UserAccountInfo doGetPreAddUserAccountInfoVo() {
        return doGetPreAddUserAccountInfoVo(null);
    }
}

