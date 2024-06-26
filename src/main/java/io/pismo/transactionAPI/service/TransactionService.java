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
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    OperationTypeRepository operationTypeRepository;

    @Transactional(Transactional.TxType.REQUIRED)
    public TransactionResponseDto create(TransactionRequestDto requestDto) {
        Account requestedAcc = accountRepository.findById(requestDto.getAccountId())
                .orElseThrow(() -> new AccountNotFoundException(requestDto.getAccountId()));
        OperationType requestedOp = operationTypeRepository.findById(requestDto.getOperationTypeId())
                .orElseThrow(() -> new InvalidOperationTypeException(requestDto.getOperationTypeId()));
        BigDecimal amount = requestedOp.isCredit()
                ? requestDto.getAmount() : requestDto.getAmount().negate();
        if(requestedOp.isCredit()){
            List<Transaction> txns = transactionRepository.findIncompleteTransactions(requestedAcc.getId());
            if(!txns.isEmpty()) {
                amount = processPendingTransactions(txns, amount);
                transactionRepository.saveAll(txns);
            }
        }

        Transaction newTxn = Transaction.builder().account(requestedAcc).amount(amount).balance(amount)
                                .operationType(requestedOp).eventDate(LocalDateTime.now()).build();
        return transactionRepository.save(newTxn).toResponseDto();
    }

    BigDecimal processPendingTransactions(List<Transaction> txns, BigDecimal amount) {
        BigDecimal remBalance = amount;
        for(Transaction t : txns){
            if(t.getBalance().add(remBalance).compareTo(BigDecimal.ZERO) >= 0){
                remBalance = remBalance.add(t.getBalance());
                t.setBalance(new BigDecimal(0.0));
            } else{
                t.setBalance(t.getBalance().add(remBalance));
                remBalance = BigDecimal.ZERO;
                break;
            }
        }
        return remBalance;
    }

}
