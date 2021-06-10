package com.task.wordcounter.model.util;

import com.task.wordcounter.entity.TextResult;
import com.task.wordcounter.model.TextResultDto;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class TextResultTransformer {
    public static TextResultDto transform(TextResult textResult){
        return TextResultDto
                .builder()
                .text(textResult.getText())
                .result(textResult.getResult())
                .uniqueWords(textResult.getUniqueWords())
                .build();
    }
}
