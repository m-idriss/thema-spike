package com.dime.thema.feature_word.services.impl;

import com.dime.thema.feature_word.exception.ResourceNotFoundException;
import com.dime.thema.feature_word.model.WordResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ContextConfiguration
class WordServiceImplTest {

    @Autowired
    WordServiceImpl wordServiceImpl;

    @Test
    @DisplayName("Get synonyms for a valid word")
    void testGetSynonymsForWord() {
        try {
            WordResponse wordResponse = wordServiceImpl.getSynonymsForWord("school");
            assertThat(wordResponse.getSynonyms()).containsExactlyElementsOf(Arrays.asList("shoal", "school day", "schooltime", "civilise", "civilize", "cultivate", "educate", "train", "schooling", "schoolhouse"));
            assertThat(wordResponse.getWord()).isEqualTo("school");
        } catch (Exception e) {
            Assertions.fail("Unexpected exception occurred: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Get synonyms for an invalid word")
    void testGetSynonymsForWord_ResourceNotFoundException() {
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> wordServiceImpl.getSynonymsForWord("toto"));
        assertThat(exception.getMessage()).isEqualTo("synonyms not found for : toto");
    }


}
