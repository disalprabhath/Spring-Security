package com.project.spring_security.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/loan")
public class LoanController {

    @GetMapping("loan")
    public String getAccountDetails(){
        return "here are the Loan details";
    }
}
