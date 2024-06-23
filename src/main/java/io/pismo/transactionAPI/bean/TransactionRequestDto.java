package io.pismo.transactionAPI.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
public class TransactionRequestDto {

    @JsonProperty("account_id")
    private Long accountId;

    @JsonProperty("operation_type_id")
    private Long operationTypeId;

    @JsonProperty("amount")
    private BigDecimal amount;
}
