package io.pismo.transactionAPI.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor(access = PRIVATE)
@Builder
@Schema(description = "Transaction Response Object")
public class TransactionRequestDto {

    @JsonProperty("account_id")
    @Schema(name = "account", description = "Account identifier for the transaction", example = "1")
    @NotNull private Long accountId;

    @JsonProperty("operation_type_id")
    @Schema(name = "operation_type", description = "Operation Type Identifier for the transaction. Following values are supported currently:<br><ol>"
            + "<li>Normal Purchase</li><li>Purchase with installments</li><li>Withdrawal</li><li>Credit Voucher</li></ol>", example = "1")
    @NotNull private Long operationTypeId;

    @JsonProperty("amount")
    @Schema(name = "amount", description = "A positive floating number which represents amount to be credited or debited. " +
            "<br>API will perform credit or debit based on operation type.", example = "100.00")
    @Positive @NotNull private BigDecimal amount;
}
