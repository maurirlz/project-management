package com.meb.projectmanagement.controllers;

import com.meb.projectmanagement.dao.UserAccountRepository;
import com.meb.projectmanagement.entities.UserAccount;
import com.meb.projectmanagement.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

    private BCryptPasswordEncoder bCryptEncoder;
    private UserAccountService accountService;

    @Autowired
    public SecurityController(BCryptPasswordEncoder bCryptEncoder, UserAccountService accountService) {
        this.bCryptEncoder = bCryptEncoder;
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public String register(Model model) {

        UserAccount user = new UserAccount();
        model.addAttribute("userAccount", user);

        return "security/register";
    }

    @PostMapping(value = "/register/save")
    public String saveUser(Model model, UserAccount user) {

        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        accountService.save(user);

        return "redirect:/";
    }
}
