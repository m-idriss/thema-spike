package com.dime.thema.feature_word.services;

import com.dime.thema.feature_word.exception.ResourceNotFoundException;
import com.dime.thema.feature_word.model.WordResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface WordService {
    WordResponse getSynonymsForWord(String word) throws ResourceNotFoundException, IOException;


}
