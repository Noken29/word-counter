package com.task.wordcounter.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TextResultDto {
    private Text text;
    private HashMap<String, Long> result;
    private Long uniqueWords;
}
