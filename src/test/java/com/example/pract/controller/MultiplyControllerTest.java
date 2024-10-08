package com.example.pract.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class MultiplyControllerTest {

    /** @noinspection SpringJavaInjectionPointsAutowiringInspection*/
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testMultiply() throws Exception {
        int number = 22;
        MockHttpServletRequestBuilder request = post("/multiply")
                .param("number", String.valueOf(number));
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(view().name("multiplication"))
                .andExpect(model().attribute("result", 44))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertThat(content).contains("44");
    }
}