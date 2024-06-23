package io.pismo.transactionAPI.exception;

import io.pismo.transactionAPI.bean.ErrorDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TransactionAPIExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorDto handleAccountNotFound(final AccountNotFoundException exception,
                                                         final HttpServletRequest request) {
        return  ErrorDto.builder().path(request.getRequestURI()).message(exception.getMessage()).build();
    }

    @ExceptionHandler(InvalidOperationTypeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorDto handleInvalidOperationTypeException(final InvalidOperationTypeException exception,
                                                        final HttpServletRequest request) {
        return  ErrorDto.builder().path(request.getRequestURI()).message(exception.getMessage()).build();
    }
}
