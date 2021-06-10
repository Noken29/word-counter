package com.task.wordcounter.api.controllers;

import com.task.wordcounter.api.service.TextService;
import com.task.wordcounter.entity.TextResult;
import com.task.wordcounter.model.Text;
import com.task.wordcounter.repository.TextRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TextService textService;

    @MockBean
    private TextRepository textRepository;

    @Test
    public void postTest() throws Exception {
        Text text = new Text("Test String");
        TextResult saved = textService.countWords(text);
        doReturn(saved).when(textRepository).save(saved);
        this.mockMvc.perform(post("/api/text")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"content\":\"Test String\"}"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}