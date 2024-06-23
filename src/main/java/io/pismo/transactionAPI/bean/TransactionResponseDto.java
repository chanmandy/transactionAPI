package io.pismo.transactionAPI.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponseDto {

    @JsonProperty("account_id")
    private Long accountId;

    @JsonProperty("operation_type_id")
    private Long operationTypeId;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("event_date")
    private LocalDateTime eventDate;
}
