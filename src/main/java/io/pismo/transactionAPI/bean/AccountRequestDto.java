package io.pismo.transactionAPI.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Schema(description = "Account Creation Request")
public class AccountRequestDto {

    @JsonProperty("document_number")
    @Schema(name = "document_number", description = "Document number for the account", example = "12345")
    @NotNull private String documentNumber;
}
