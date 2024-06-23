package io.pismo.transactionAPI.controller;

import io.pismo.transactionAPI.bean.AccountRequestDto;
import io.pismo.transactionAPI.bean.AccountResponseDto;
import io.pismo.transactionAPI.exception.AccountNotFoundException;
import io.pismo.transactionAPI.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService service;

    @Test
    void testGetById() throws Exception {
        AccountResponseDto account = AccountResponseDto.builder().id(1l).documentNumber("12345").build();
        Mockito.doReturn(account).when(service).findById(Mockito.anyLong());
        MvcResult result = mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isOk())
                .andReturn();
        String strResult = result.getResponse().getContentAsString();
        assertTrue(strResult.contains("\"document_number\":\"12345\""));
    }

    @Test
    void testGetByIdWithNonexistingAccount() throws Exception {
        Mockito.doThrow(new AccountNotFoundException(1l)).when(service).findById(Mockito.anyLong());
        MvcResult result = mockMvc.perform(get("/accounts/1"))
                .andExpect(status().is4xxClientError())
                .andReturn();
        assertEquals(404, result.getResponse().getStatus());
    }

    @Test
    void testCreate() throws Exception {
        AccountResponseDto account = AccountResponseDto.builder().id(1l).documentNumber("12345").build();
        Mockito.doReturn(account).when(service).createAccount(Mockito.any(AccountRequestDto.class));
        MvcResult result = mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"document_number\":\"12345\"}"))
                .andExpect(status().isOk())
                .andReturn();
        String strResult = result.getResponse().getContentAsString();
        assertTrue(strResult.contains("\"account_id\":1"));
    }
}