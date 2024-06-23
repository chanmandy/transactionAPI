package io.pismo.transactionAPI.service;

import io.pismo.transactionAPI.bean.AccountRequestDto;
import io.pismo.transactionAPI.bean.AccountResponseDto;
import io.pismo.transactionAPI.exception.AccountNotFoundException;
import io.pismo.transactionAPI.model.Account;
import io.pismo.transactionAPI.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountResponseDto findById(Long id) {
        return accountRepository.findById(id).map(Account::toResponseDto)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    public AccountResponseDto createAccount(AccountRequestDto requestDto) {
        Account newAccount = Account.builder().documentNumber(requestDto.getDocumentNumber()).build();
        return accountRepository.save(newAccount).toResponseDto();
    }
}
