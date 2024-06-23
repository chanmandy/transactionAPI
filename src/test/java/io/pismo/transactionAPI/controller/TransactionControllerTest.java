package io.pismo.transactionAPI.controller;

import io.pismo.transactionAPI.bean.TransactionRequestDto;
import io.pismo.transactionAPI.bean.TransactionResponseDto;
import io.pismo.transactionAPI.exception.AccountNotFoundException;
import io.pismo.transactionAPI.exception.InvalidOperationTypeException;
import io.pismo.transactionAPI.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService service;

    @Test
    void testCreate() throws Exception {
        TransactionResponseDto responseDto = TransactionResponseDto.builder().transactionId(1l)
                .accountId(1l).operationTypeId(1l).eventDate(LocalDateTime.now()).build();
        Mockito.doReturn(responseDto).when(service).create(Mockito.any(TransactionRequestDto.class));
        MvcResult result = mockMvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"account_id\":1,\"operation_type_id\":1,\"amount\":100.0}"))
                .andExpect(status().isCreated())
                .andReturn();
        String strResult = result.getResponse().getContentAsString();
        assertTrue(strResult.contains("\"transaction_id\":1"));
    }

    @Test
    void testCreateWithNonexistingAccount() throws Exception {
        Mockito.doThrow(new AccountNotFoundException(1l)).when(service).create(Mockito.any(TransactionRequestDto.class));
        mockMvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"account_id\":1,\"operation_type_id\":1,\"amount\":100.0}"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testCreateWithInvalidOperationType() throws Exception {
        Mockito.doThrow(new InvalidOperationTypeException(1l)).when(service).create(Mockito.any(TransactionRequestDto.class));
        mockMvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("{\"account_id\":1,\"operation_type_id\":1,\"amount\":100.0}"))
                .andExpect(status().isBadRequest());
    }

}