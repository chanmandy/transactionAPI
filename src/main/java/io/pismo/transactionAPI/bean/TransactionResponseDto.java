package io.pismo.transactionAPI.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Builder
@Data
@AllArgsConstructor(access = PRIVATE)
@Schema(description = "Transaction Response Object")
public class TransactionResponseDto {

    @JsonProperty("transaction_id")
    @Schema(name = "id", description = "Identifier for the transaction", example = "1")
    @NotNull private Long transactionId;

    @JsonProperty("account_id")
    @Schema(name = "account", description = "Account identifier for the transaction", example = "1")
    @NotNull private Long accountId;

    @JsonProperty("operation_type_id")
    @Schema(name = "operation_type", description = "Operation Type Identifier for the transaction. Following values are supported currently:<br><ol>"
            + "<li>Normal Purchase</li><li>Purchase with installments</li><li>Withdrawal</li><li>Credit Voucher</li></ol>", example = "1")
    @NotNull private Long operationTypeId;

    @JsonProperty("amount")
    @Schema(name = "amount", description = "A floating number which represents amount. " +
            "<br>Positve value represents a credit and negative value represents debit", example = "-100.00")
    @NotNull private BigDecimal amount;

    @JsonProperty("event_date")
    @Schema(name = "event_date", description = "Transaction timestamp based on system timezone.", example = "2024-06-23T14:45:57.367378219")
    @NotNull private LocalDateTime eventDate;

    @JsonProperty("balance")
    @Schema(name = "balance", description = "A floating number which represents balance. " +
            "<br>Negative value represents payment is not dischared for the transaction. Zero represents payment is successfully done ", example = "-100.00")
    @NotNull private BigDecimal balance;

}
