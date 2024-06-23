package io.pismo.transactionAPI.bean;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

import java.io.Serializable;

@Builder
@JsonInclude(NON_EMPTY)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorDto {

    @JsonProperty(value = "path")
    private String path;

    @JsonProperty(value = "message")
    private String message;
}
