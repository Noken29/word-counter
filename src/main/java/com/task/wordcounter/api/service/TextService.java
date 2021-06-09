package com.task.wordcounter.api.service;

import com.task.wordcounter.entity.TextResult;
import com.task.wordcounter.model.Text;
import com.task.wordcounter.repository.TextRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@AllArgsConstructor
public class TextService {
    private final TextRepository textRepository;
//    private Text text = new Text("ASD ASD ASD ADS AAA AAA\nAAA AA, DSA");
//    public TextService(TextRepository textRepository) {
//        this.textRepository = textRepository;
//        proccesText(text);
//        TextResult textResult = textRepository.findById(1L).get();
//        System.out.println(textResult == null);
//        System.out.println(textResult.getResult().get("ADS"));
//    }

    public TextResult proccesText(Text text) {
        TextResult textResult = textRepository.save(countWords(text));
        log.info("got the result: {}", textResult);
        return textResult;
    }

    public TextResult countWords(Text text) {
        String inputText = text.getText();
        String words[] = inputText.split("\\W+");
        HashMap<String, Long> result = new HashMap<>();
        long unique = 0;
        for (int i = 0; i < words.length; i++) {
            if(result.containsKey(words[i])) {
                result.put(words[i], result.get(words[i]) + 1);
            } else {
                result.put(words[i], Long.valueOf(1));
            }
        }
        unique = result.size();
        return new TextResult().builder().text(text).result(result).uniqueWords(unique).build();
    }

}
