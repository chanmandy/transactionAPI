package io.pismo.transactionAPI.service;

import io.pismo.transactionAPI.bean.TransactionRequestDto;
import io.pismo.transactionAPI.bean.TransactionResponseDto;
import io.pismo.transactionAPI.enums.LedgerEntry;
import io.pismo.transactionAPI.exception.AccountNotFoundException;
import io.pismo.transactionAPI.exception.InvalidOperationTypeException;
import io.pismo.transactionAPI.model.Account;
import io.pismo.transactionAPI.model.OperationType;
import io.pismo.transactionAPI.model.Transaction;
import io.pismo.transactionAPI.repository.AccountRepository;
import io.pismo.transactionAPI.repository.OperationTypeRepository;
import io.pismo.transactionAPI.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private OperationTypeRepository operationTypeRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void testCreate() {
        Account testAcc = Account.builder().id(1l).documentNumber("12345").build();
        Mockito.doReturn(Optional.of(testAcc)).when(accountRepository).findById(1L);
        OperationType operationType = OperationType.builder().entry(LedgerEntry.DEBIT)
                .id(1l).description("Normal Purchase").build();
        Mockito.doReturn(Optional.of(operationType)).when(operationTypeRepository).findById(1l);
        TransactionRequestDto input = TransactionRequestDto.builder().accountId(1l)
                .operationTypeId(1L).amount(new BigDecimal(100.00)).build();
        Transaction txn = Transaction.builder().id(1l).operationType(operationType).account(testAcc)
                .eventDate(LocalDateTime.now()).amount(new BigDecimal(-100.00)).build();
        Mockito.doReturn(txn).when(transactionRepository).save(Mockito.any(Transaction.class));

        TransactionResponseDto output = transactionService.create(input);

        assertNotNull(output);
        assertTrue(output.getAmount().compareTo(BigDecimal.ZERO) == -1);
    }

    @Test
    void testCreateWithNonexistingAccount() {
        Mockito.doReturn(Optional.empty()).when(accountRepository).findById(1L);
        TransactionRequestDto input = TransactionRequestDto.builder().accountId(1l)
                .operationTypeId(1L).amount(new BigDecimal(100.00)).build();

        assertThrows(AccountNotFoundException.class, () -> transactionService.create(input));
    }

    @Test
    void testCreateWithInvalidOperationType() {
        Account testAcc = Account.builder().id(1l).documentNumber("12345").build();
        Mockito.doReturn(Optional.of(testAcc)).when(accountRepository).findById(1L);
        Mockito.doReturn(Optional.empty()).when(operationTypeRepository).findById(1l);
        TransactionRequestDto input = TransactionRequestDto.builder().accountId(1l)
                .operationTypeId(1L).amount(new BigDecimal(100.00)).build();

        assertThrows(InvalidOperationTypeException.class, () -> transactionService.create(input));
    }

}