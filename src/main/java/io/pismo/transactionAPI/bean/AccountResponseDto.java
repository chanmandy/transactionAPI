package io.pismo.transactionAPI.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
public class AccountResponseDto {

    @NotNull
    @JsonProperty("account_id")
    private Long id;

    @NotNull
    @JsonProperty("document_number")
    private String documentNumber;
}
