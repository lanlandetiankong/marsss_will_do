package com.marsss.marsss_will_do.controller.user;

import com.marsss.marsss_will_do.bean.user.UserAccountBean;
import com.marsss.marsss_will_do.common.constant.MyBaseCommonResult;
import com.marsss.marsss_will_do.common.enums.user.UserAccountBaseTypeEnum;
import com.marsss.marsss_will_do.common.enums.user.UserAccountRegisterTypeEnum;
import com.marsss.marsss_will_do.common.properties.UserCustomProperties;
import com.marsss.marsss_will_do.common.test.RandomValueUtil;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.utils.auth.MyUserLoginAuth;
import com.marsss.marsss_will_do.utils.password.MyPasswordUtil;
import com.marsss.marsss_will_do.utils.pinyin.MyPinYinUtil;
import com.marsss.marsss_will_do.utils.uuid.MyUUIDUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/apis/user_account_info")
public class UserAccountInfoController {
    @Autowired
    private UserCustomProperties userCustomProperties ;
    @Autowired
    private UserAccountRepository userAccountRepository ;

    @ApiOperation(value = "用户注册",notes = "测试数据(用户)生成接口")
    @PostMapping("/add_user_account")
    public String doRegisterUserAccount(String userName,String password) {
        UserAccount userAccount = new UserAccount() ;
        userAccount.setEmail(RandomValueUtil.getEmail(10,15));
        userAccount.setSex(1);
        //用户名
        userAccount.setNickName(RandomValueUtil.getChineseName());
        userAccount.setNickNameSpell(MyPinYinUtil.toPinyin(userAccount.getNickName()));
        userAccount.setUserName(RandomValueUtil.getChineseName());
        userAccount.setUserNameSpell(MyPinYinUtil.toPinyin(userAccount.getUserName()));

        //密码
        userAccount.setSalt(MyUUIDUtil.renderSimpleUUID());
        userAccount.setPassword(MyPasswordUtil.renderMd5Password(userCustomProperties.getDefaultPassword(),userAccount.getSalt()));
        userAccount.setTelephone(RandomValueUtil.getTel());
        userAccount.setBaseType(UserAccountBaseTypeEnum.SIMPLE_USER.getValue());
        userAccount.setRegisterType(UserAccountRegisterTypeEnum.FRONT_REGISTER.getValue());
        userAccount.setState(1);
        userAccountRepository.save(userAccount) ;
        return "ok" ;
    }

    @ApiOperation(value = "用户登录",notes = "用户登录认证")
    @PostMapping("/do_login")
    public MyBaseCommonResult doLogin(HttpSession session, UserAccountBean userAccountBean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            MyUserLoginAuth.authIsUserLogin(userAccountBean) ;
            UserAccount realUserAccounts = userAccountRepository.getUserAccountByUserAccount(userAccountBean.getAccount());
            if(realUserAccounts == null) {
                throw new SecurityException("用户不存在!") ;
            }
            boolean isAuthUserAccount = MyPasswordUtil.varifyMd5PasswordIsTrue(userAccountBean.getPassword(),realUserAccounts);
            if(isAuthUserAccount) {
                throw new SecurityException("用户账号与密码不匹配！");
            }
            result.setInfo(realUserAccounts.getNickName()+",登录成功！");
            result.setBean(realUserAccounts);
        }   catch (SecurityException e) {
            result.setHasWarning(true);
            result.setActionFlag(false);
            result.setInfo("登录失败："+e.getMessage());
        }   catch (Exception e) {
            result.setHasError(true);
            result.setInfo("登录失败："+e.getMessage());
        }
        return result ;
    }




}
