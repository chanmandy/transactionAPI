package io.pismo.transactionAPI.service;

import io.pismo.transactionAPI.bean.AccountRequestDto;
import io.pismo.transactionAPI.bean.AccountResponseDto;
import io.pismo.transactionAPI.exception.AccountNotFoundException;
import io.pismo.transactionAPI.model.Account;
import io.pismo.transactionAPI.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    void testFindById() {
        Account testAcc = Account.builder().id(1l).documentNumber("12345").build();
        Mockito.doReturn(testAcc).when(accountRepository).findById(1l);
        AccountResponseDto output = accountService.findById(1l);
        assertNotNull(output);
        assertEquals("12345",output.getDocumentNumber());
    }

    @Test
    void testFindByIdWithNonexistingAccount() {
        Mockito.doReturn(Optional.empty()).when(accountRepository).findById(1l);
        assertThrows(AccountNotFoundException.class, () -> accountService.findById(1l));
    }

    @Test
    void testCreate() {
        Account testAcc = Account.builder().id(1l).documentNumber("12345").build();
        Mockito.doReturn(testAcc).when(accountRepository).save(Mockito.any(Account.class));
        AccountRequestDto input = AccountRequestDto.builder().documentNumber("12345").build();

        AccountResponseDto output = accountService.createAccount(input);
        assertNotNull(output);
        assertEquals(1l, output.getId());
    }
}