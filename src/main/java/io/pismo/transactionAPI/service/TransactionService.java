package io.pismo.transactionAPI.service;

import io.pismo.transactionAPI.bean.TransactionRequestDto;
import io.pismo.transactionAPI.bean.TransactionResponseDto;
import io.pismo.transactionAPI.exception.AccountNotFoundException;
import io.pismo.transactionAPI.exception.InvalidOperationTypeException;
import io.pismo.transactionAPI.model.Account;
import io.pismo.transactionAPI.model.OperationType;
import io.pismo.transactionAPI.model.Transaction;
import io.pismo.transactionAPI.repository.AccountRepository;
import io.pismo.transactionAPI.repository.OperationTypeRepository;
import io.pismo.transactionAPI.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class TransactionService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    OperationTypeRepository operationTypeRepository;

    public TransactionResponseDto create(TransactionRequestDto requestDto) {
        Account requestedAcc = accountRepository.findById(requestDto.getAccountId())
                .orElseThrow(() -> new AccountNotFoundException(requestDto.getAccountId()));
        OperationType requestedOp = operationTypeRepository.findById(requestDto.getOperationTypeId())
                .orElseThrow(() -> new InvalidOperationTypeException(requestDto.getOperationTypeId()));
        BigDecimal amount = requestedOp.isCredit() ? requestDto.getAmount() : requestDto.getAmount().negate();

        Transaction newTxn = Transaction.builder().account(requestedAcc).amount(amount)
                                .operationType(requestedOp).eventDate(LocalDateTime.now()).build();
        return transactionRepository.save(newTxn).toResponseDto();
    }
}
