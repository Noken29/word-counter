package com.task.wordcounter.api.service;

import com.task.wordcounter.entity.TextResult;
import com.task.wordcounter.model.Text;
import com.task.wordcounter.repository.TextRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class TextServiceTest {
    @Autowired
    private TextService textService;

    @MockBean
    private TextRepository textRepository;

    @Test
    public void countWordsTest() {
        Text testText = new Text("Example. Example test string\nwhere used big word number.\ntest string");
        Long unique = 8L;
        TextResult textResult = textService.countWords(testText);
        assertEquals(textResult.getUniqueWords(), unique);
        assertEquals(textResult.getText(), testText);
    }

    @Test
    public void proccesTextTest() {
        Text testText = new Text("Example. Example test string\nwhere used big word number.\ntest string");
        TextResult testTestResult = textService.countWords(testText);
        Mockito.doReturn(testTestResult)
                .when(textRepository)
                .save(testTestResult);
        TextResult textResult = textService.proccesText(testText);
        Mockito.verify(textRepository, Mockito.times(1)).save(textResult);
        assertEquals(textResult, testTestResult);
    }
}