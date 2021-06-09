package com.task.wordcounter.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Text implements Serializable {
    private String text;
}
