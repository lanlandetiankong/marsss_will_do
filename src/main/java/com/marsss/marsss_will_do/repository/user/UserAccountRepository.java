package com.marsss.marsss_will_do.repository.user;

import com.marsss.marsss_will_do.common.base.dao.MySimpleRepository;
import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface UserAccountRepository extends MySimpleRepository<UserAccount,String> {
    /**
     * 根据用户账号查询用户用户
     * @param account
     * @return
     */
    @Query("select u from UserAccount u where u.account = :account")
    UserAccount getUserAccountByUserAccount(@Param("account") String account);

    /**
     * 根据用户邮箱查询用户用户
     * @param email
     * @return
     */
    @Query("select u from UserAccount u where u.email = :email")
    UserAccount getUserAccountByUserEmail(@Param("email") String email);

}
