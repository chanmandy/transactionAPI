package io.pismo.transactionAPI.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor(access = PRIVATE)
@Builder
@Schema(description = "Account Response Object")
public class AccountResponseDto {

    @JsonProperty("account_id")
    @Schema(name = "id", description = "Identifier of the account", example = "1")
    @NotNull private Long id;

    @JsonProperty("document_number")
    @Schema(name = "document_number", description = "Document number for the account", example = "12345")
    @NotNull private String documentNumber;
}
