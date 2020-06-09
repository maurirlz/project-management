package com.meb.projectmanagement.services;

import com.meb.projectmanagement.dao.UserAccountRepository;
import com.meb.projectmanagement.entities.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    private final UserAccountRepository userRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserAccount save(UserAccount account) {

        return userRepository.save(account);
    }
}
