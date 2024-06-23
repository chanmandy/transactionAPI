package io.pismo.transactionAPI.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Data
@AllArgsConstructor(access = PRIVATE)
public class TransactionResponseDto {

    @JsonProperty("transaction_id")
    private Long transactionId;

    @JsonProperty("account_id")
    private Long accountId;

    @JsonProperty("operation_type_id")
    private Long operationTypeId;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("event_date")
    private LocalDateTime eventDate;
}
