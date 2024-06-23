package io.pismo.transactionAPI.service;

import io.pismo.transactionAPI.repository.AccountRepository;
import io.pismo.transactionAPI.repository.OperationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

}
