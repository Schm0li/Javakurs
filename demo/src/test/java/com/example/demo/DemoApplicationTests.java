package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class DemoApplicationTests {
    @Autowired MockMvc mockMvc;
    @Autowired NameService nameService;

    @Test
    void contextLoads() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("name", ""))
                .andExpect(content().string(containsString("Hallo")));

        int before = nameService.findAll().size();
        mockMvc.perform(post("/name").param("name", "Oliver"));
        assertEquals(before + 1, nameService.findAll().size());
    }

}
