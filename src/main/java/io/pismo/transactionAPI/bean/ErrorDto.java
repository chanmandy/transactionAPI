package io.pismo.transactionAPI.bean;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Standard Error Responses")
public class ErrorDto {

    @JsonProperty(value = "path")
    @Schema(description = "Relative API URL for the error")
    private String path;

    @JsonProperty(value = "message")
    @Schema(description = "Error description")
    private String message;
}
