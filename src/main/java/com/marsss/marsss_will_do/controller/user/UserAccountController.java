package com.marsss.marsss_will_do.controller.user;

import com.marsss.marsss_will_do.bean.user.UserAccountBean;
import com.marsss.marsss_will_do.bean.user.UserAccountBeanFormat;
<<<<<<< HEAD
=======
import com.marsss.marsss_will_do.common.base.controller.MyBaseController;
>>>>>>> temp
import com.marsss.marsss_will_do.common.constant.MyBaseCommonResult;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.service.user.UserAccountInfoService;
import com.marsss.marsss_will_do.service.user.UserAccountService;
import com.marsss.marsss_will_do.utils.auth.MyUserLoginAuth;
import com.marsss.marsss_will_do.utils.password.MyPasswordUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
=======
import javax.servlet.http.HttpServletRequest;
>>>>>>> temp
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/apis/user_account")
<<<<<<< HEAD
public class UserAccountController {
=======
public class UserAccountController extends MyBaseController{
>>>>>>> temp


    @Autowired
    private UserAccountService userAccountService ;
    @Autowired
    private UserAccountInfoService userAccountInfoService ;

    @ApiOperation(value = "用户注册",notes = "测试数据(用户)生成接口")
    @PostMapping("/add_user_account")
    public MyBaseCommonResult doRegisterUserAccount(UserAccountBean userAccountBean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = userAccountService.doAddUserAccount(userAccountBean);
            result.setBean(userAccount);
        }   catch (Exception e){
            result.setHasError(true);
            result.setInfo("创建用户["+userAccountBean.getNickName()+"]失败！"+e.getMessage());
        }
        return result ;
    }

    @ApiOperation(value = "用户登录",notes = "用户登录认证")
    @PostMapping("/do_login")
<<<<<<< HEAD
    public MyBaseCommonResult doLogin(HttpSession session, UserAccountBean userAccountBean) {
=======
    public MyBaseCommonResult doLogin(HttpServletRequest  request, UserAccountBean userAccountBean) {
>>>>>>> temp
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            MyUserLoginAuth.authIsUserLogin(userAccountBean) ;
            UserAccount realUserAccounts = userAccountService.doGetUserAccountByAccountId(userAccountBean.getAccount());
            if(realUserAccounts == null) {
                throw new SecurityException("用户不存在!") ;
            }
            boolean isAuthUserAccount = MyPasswordUtil.varifyMd5PasswordIsTrue(userAccountBean.getPassword(),realUserAccounts);
            if(isAuthUserAccount) {
                throw new SecurityException("用户账号与密码不匹配！");
            }
            result.setInfo(realUserAccounts.getNickName()+",登录成功！");
<<<<<<< HEAD
            result.setBean(UserAccountBeanFormat.entityToBean(realUserAccounts));
=======
            //设置返回给前端的token
            result.setBean(super.handleLoginCacheUserToken(request,realUserAccounts));
>>>>>>> temp
        }   catch (SecurityException e) {
            result.setHasWarning(true);
            result.setActionFlag(false);
            result.setInfo("登录失败："+e.getMessage());
        }   catch (Exception e) {
            result.setHasError(true);
<<<<<<< HEAD
=======
            result.setActionFlag(false);
>>>>>>> temp
            result.setInfo("登录失败："+e.getMessage());
        }
        return result ;
    }




}
