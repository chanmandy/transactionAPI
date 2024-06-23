package io.pismo.transactionAPI.controller;

import io.pismo.transactionAPI.bean.AccountRequestDto;
import io.pismo.transactionAPI.bean.AccountResponseDto;
import io.pismo.transactionAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> getById(@PathVariable long id){
        return new ResponseEntity<>(accountService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AccountResponseDto> create(@RequestBody AccountRequestDto account){
        return new ResponseEntity<>(accountService.createAccount(account),HttpStatus.OK);
    }
}
