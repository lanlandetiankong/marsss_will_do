package com.marsss.marsss_will_do.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.marsss.marsss_will_do.bean.MyEmailSendBean;
import com.marsss.marsss_will_do.bean.user.UserAccountBean;
import com.marsss.marsss_will_do.bean.user.UserAccountBeanFormat;
import com.marsss.marsss_will_do.common.base.controller.MyBaseController;
import com.marsss.marsss_will_do.common.constant.MyBaseCommonResult;
import com.marsss.marsss_will_do.common.enums.email.MyUserEmailEnum;
import com.marsss.marsss_will_do.common.exception.user.UserAccountRegisteredException;
import com.marsss.marsss_will_do.config.redis.RedisHelper;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import com.marsss.marsss_will_do.repository.user.UserAccountRepository;
import com.marsss.marsss_will_do.service.email.user.UserEmailService;
import com.marsss.marsss_will_do.service.user.UserAccountInfoService;
import com.marsss.marsss_will_do.service.user.UserAccountService;
import com.marsss.marsss_will_do.utils.auth.MyUserLoginAuth;
import com.marsss.marsss_will_do.utils.password.MyPasswordUtil;
import com.marsss.marsss_will_do.utils.regex.RegexUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@RestController
@RequestMapping("/apis/user_account")
public class UserAccountController extends MyBaseController{


    @Autowired
    private UserAccountService userAccountService ;
    @Autowired
    private UserAccountInfoService userAccountInfoService ;
    @Autowired
    private UserEmailService userEmailService ;

    @Autowired
    private UserAccountRepository userAccountRepository ;
    @Autowired
    private RedisHelper<String,UserAccount> userAccountRedisHelper ;
    @Autowired
    private RedisHelper<String,UserAccountBean> userAccountBeanRedisHelper ;



    private MyUserEmailEnum defaultUserEmailEnum = MyUserEmailEnum.Default;

    @ApiOperation(value = "用户注册",notes = "测试数据(用户)生成接口")
    @PostMapping("/test_register")
    public MyBaseCommonResult doAddUserAccount(UserAccountBean userAccountBean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            UserAccount userAccount = userAccountService.doAddUserAccount(userAccountBean);
            result.setBean(userAccount);
        }   catch (Exception e){
            result.setHasError(true);
            result.setActionFlag(false);
            result.setInfo("创建用户["+userAccountBean.getNickName()+"]失败！"+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "用户登录",notes = "用户登录认证")
    @PostMapping("/do_login")
    public MyBaseCommonResult doLogin(HttpServletRequest  request, UserAccountBean userAccountBean) {
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
            result.setBean(UserAccountBeanFormat.entityToBean(realUserAccounts));
            //设置返回给前端的token
            result.setBean(super.handleLoginCacheUserToken(request,realUserAccounts));
        }   catch (SecurityException e) {
            result.setHasWarning(true);
            result.setActionFlag(false);
            result.setInfo("登录失败："+e.getMessage());
        }   catch (Exception e) {
            result.setHasError(true);
            result.setActionFlag(false);
            result.setInfo("登录失败："+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }

    @ApiOperation(value = "用户注册",notes = "用户注册接口")
    @PostMapping("/register")
    public MyBaseCommonResult doRegisterAccount(HttpServletRequest request,UserAccountBean accountBean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            //字段验证
            userAccountService.handleRegisterValidate(request,accountBean) ;
            String account = accountBean.getAccount() ;
            String accountBeanEmail = accountBean.getEmail();
            String validateCode = accountBean.getValidateCode();
            String redisKey = RedisHelper.DB_KEY_AUTHCODE+account ;
            UserAccountBean redisUserAccountBean = userAccountBeanRedisHelper.getValue(redisKey);
            if(redisUserAccountBean == null){
                throw new Exception("用户账号 " +account +" 的验证码可能已失效。(发送验证码之后修改用户账号的话将导致验证码失效！)");
            }
            String  redisUserAccountBeanAccount = redisUserAccountBean.getAccount() ;
            String redisUserAccountBeanEmail = redisUserAccountBean.getEmail();
            String redisUserAccountBeanValidateCode = redisUserAccountBean.getValidateCode();
            if(account.equals(redisUserAccountBeanAccount) && accountBeanEmail.equals(redisUserAccountBeanEmail) && validateCode.equals(redisUserAccountBeanValidateCode)){
                UserAccountBean registerUserAccountBean = userAccountService.doRegisterUserAccount(accountBean);
                result.setBean(registerUserAccountBean);
                result.setInfo("用户 " + accountBean.getAccount() + " 注册成功！");
            }   else {
                throw new Exception("用户账号 " +account +" 的验证码不匹配！(发送验证码之后修改用户账号的话将导致验证码失效！)");
            }
        }   catch (Exception e){
            result.setHasError(true);
            result.setActionFlag(false);
            result.setInfo("用户注册失败："+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }


    @ApiOperation(value = "用户注册邮箱验证码",notes = "用户注册邮箱验证接口")
    @PostMapping("/register/email_check")
    public MyBaseCommonResult doRegisterEmailCheck(HttpServletRequest request,UserAccountBean accountBean) {
        MyBaseCommonResult result = new MyBaseCommonResult() ;
        try{
            if(accountBean == null){
                throw new Exception("前端数据传入错误！") ;
            }
            String account = accountBean.getAccount() ;
            if(StringUtils.isBlank(account)){
                throw new Exception("请先填写<登录账号>字段！") ;
            }

            String toEmail = accountBean.getEmail() ;
            if(StringUtils.isBlank(toEmail)){
                throw new Exception("传入的邮箱不能为空！") ;
            }
            if(RegexUtil.checkEmail(toEmail) == false) {
                throw new Exception("传入的邮箱不是有效的邮箱格式！") ;
            }
            if(userAccountService.doCheckIsAccountExistByAccount(account)) {
                throw new UserAccountRegisteredException("用户账号 ",account);
            }
            //存放 验证码到 redis
            String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
            String redisKey = RedisHelper.DB_KEY_AUTHCODE+account ;
            redisKey = redisKey.trim();
            if(redisHelper.isExistKey(redisKey)){
                redisHelper.remove(redisKey);
            }
            accountBean.setValidateCode(checkCode);
            redisHelper.valuePut(redisKey,accountBean,defaultUserEmailEnum.getLimitTime(),defaultUserEmailEnum.getTimeUnit());

            //发送email
            MyEmailSendBean emailSendBean = new MyEmailSendBean(checkCode) ;
            userEmailService.sendSimpleEmail(toEmail,emailSendBean);
            result.setInfo("验证码已发送到 "+toEmail+" ,请登录邮箱将验证码填写到表单中后提交注册申请！");
        }   catch (Exception e){
            result.setHasError(true);
            result.setActionFlag(false);
            result.setInfo("发送验证码到用户邮箱失败！："+e.getMessage());
            e.printStackTrace();
        }
        return result ;
    }
}
