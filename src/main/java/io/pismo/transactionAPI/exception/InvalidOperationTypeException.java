package io.pismo.transactionAPI.exception;

public class InvalidOperationTypeException extends TransactionAPIException{

    public static final String INVALID_OPERATION_TYPE_MESSAGE = "Operation Type not found with id %d";

    public InvalidOperationTypeException(Long id) {
        super(String.format(INVALID_OPERATION_TYPE_MESSAGE, id));
    }

}
