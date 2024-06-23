package io.pismo.transactionAPI.service;

import io.pismo.transactionAPI.repository.OperationTypeRepository;
import io.pismo.transactionAPI.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    OperationTypeRepository operationTypeRepository;

}
