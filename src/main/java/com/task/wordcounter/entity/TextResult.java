package com.task.wordcounter.entity;

import com.task.wordcounter.model.Text;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;

@Data
@Entity
@Table(name = "result")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Text text;
    private HashMap<String, Long> result;
    private Long uniqueWords;
}
