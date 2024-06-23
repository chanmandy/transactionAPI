package io.pismo.transactionAPI.exception;

import io.pismo.transactionAPI.bean.ErrorDto;

public class TransactionAPIException extends RuntimeException{

    private final String path;
    private final String message;

    public TransactionAPIException(String path, String message, Throwable cause) {
        super(message, cause);
        this.path = path;
        this.message = message;
    }

    public TransactionAPIException(String path, String message) {
        this(path, message, null);
    }

    public TransactionAPIException(String message) {
        this(null, message, null);
    }

    public ErrorDto toResponse() {
        return ErrorDto.builder().path(path).message(message).build();
    }

}
