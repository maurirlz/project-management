package com.meb.projectmanagement.dao;

import com.meb.projectmanagement.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
