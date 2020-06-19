package com.meb.projectmanagement.dao;

import com.meb.projectmanagement.entities.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apiaccounts", path="apiaccounts")
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {

}
