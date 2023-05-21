package com.dime.thema.feature_word.repository;

import com.dime.thema.feature_word.model.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends CrudRepository<Word, Long> {
}
