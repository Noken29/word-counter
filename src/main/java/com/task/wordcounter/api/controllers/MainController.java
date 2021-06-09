package com.task.wordcounter.api.controllers;

import com.task.wordcounter.api.service.TextService;
import com.task.wordcounter.model.Text;
import com.task.wordcounter.model.TextResultDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.task.wordcounter.model.util.TextResultTransformer.transform;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/text")
public class MainController {

    private final TextService textService;

    @PostMapping
    public TextResultDto post(@RequestBody Text text) {
        log.info("host will accept request: {}", text);
        return transform(textService.proccesText(text));
    }
}
