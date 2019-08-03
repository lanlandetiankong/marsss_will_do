package com.marsss.marsss_will_do.repository.user;

import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface UserAccountRepository extends JpaRepository<UserAccount,String> {
    @Query("select u from UserAccount u where u.account = :account")
    UserAccount getUserAccountByUserAccount(@Param("account") String account);



}
