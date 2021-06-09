package com.task.wordcounter.repository;

import com.task.wordcounter.entity.TextResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextRepository extends JpaRepository<TextResult, Long> {
}
