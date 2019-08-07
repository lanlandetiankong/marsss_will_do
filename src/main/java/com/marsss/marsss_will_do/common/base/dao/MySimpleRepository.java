package com.marsss.marsss_will_do.common.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface MySimpleRepository<T,K> extends JpaRepository<T,K>,CrudRepository<T,K>,PagingAndSortingRepository<T,K> {

}
