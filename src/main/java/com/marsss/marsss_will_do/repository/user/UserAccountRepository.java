package com.marsss.marsss_will_do.repository.user;

<<<<<<< HEAD
=======
import com.marsss.marsss_will_do.common.base.dao.MySimpleRepository;
>>>>>>> temp
import com.marsss.marsss_will_do.entity.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
<<<<<<< HEAD
public interface UserAccountRepository extends JpaRepository<UserAccount,String> {
=======
public interface UserAccountRepository extends MySimpleRepository<UserAccount,String> {
>>>>>>> temp
    @Query("select u from UserAccount u where u.account = :account")
    UserAccount getUserAccountByUserAccount(@Param("account") String account);



}
