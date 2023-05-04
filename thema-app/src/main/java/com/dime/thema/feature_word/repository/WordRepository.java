package com.dime.thema.feature_word.repository;

import com.dime.thema.feature_word.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
