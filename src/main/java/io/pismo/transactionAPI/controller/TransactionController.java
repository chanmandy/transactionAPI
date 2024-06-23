package io.pismo.transactionAPI.controller;

import io.pismo.transactionAPI.bean.AccountRequestDto;
import io.pismo.transactionAPI.bean.TransactionRequestDto;
import io.pismo.transactionAPI.bean.TransactionResponseDto;
import io.pismo.transactionAPI.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity<TransactionResponseDto> create(@RequestBody TransactionRequestDto transaction){
        //todo implementation
        return null;
    }

}
