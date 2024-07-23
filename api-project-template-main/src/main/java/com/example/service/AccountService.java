package com.example.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }


}
