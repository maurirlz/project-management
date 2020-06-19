package com.meb.projectmanagement.dao;

import com.meb.projectmanagement.entities.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {

}
