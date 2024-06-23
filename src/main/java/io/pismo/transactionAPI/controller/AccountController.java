package io.pismo.transactionAPI.controller;

import io.pismo.transactionAPI.bean.AccountRequestDto;
import io.pismo.transactionAPI.bean.AccountResponseDto;
import io.pismo.transactionAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountResponseDto> getById(@PathVariable long id){
        //todo implementation
        return null;
    }

    @PostMapping("/accounts")
    public ResponseEntity<AccountResponseDto> create(@RequestBody AccountRequestDto account){
        //todo implementation
        return null;
    }
}