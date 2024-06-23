package io.pismo.transactionAPI.bean;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

import static lombok.AccessLevel.PRIVATE;

@AllArgsConstructor(access = PRIVATE)
public class AccountRequestDto {

    @NotNull
    @JsonProperty("document_number")
    private String documentNumber;
}
