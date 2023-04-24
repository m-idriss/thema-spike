package com.dime.thema.feature_word.services;

import com.dime.thema.feature_word.exception.ResourceNotFoundException;
import com.dime.thema.feature_word.model.WordResponse;

import java.io.IOException;

public interface WordService {
    WordResponse getSynonymsForWord(String word) throws ResourceNotFoundException, IOException;


}
