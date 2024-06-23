package io.pismo.transactionAPI.exception;

public class AccountNotFoundException extends TransactionAPIException{

    public static final String ACCOUNT_NOT_FOUND_MESSAGE = "Account not found with id %d";

    public AccountNotFoundException(Long id) {
        super(String.format(ACCOUNT_NOT_FOUND_MESSAGE, id));
    }
}
