package com.project.spring_security.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/account")
public class AccountController {

    @GetMapping("my_account")
//    @Secured("ROLE_ADMIN")
//    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getAccountDetails(){
        System.out.println("out");
        return "Here are the account details";
    }
}
