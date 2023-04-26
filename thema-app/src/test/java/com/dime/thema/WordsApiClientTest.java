package com.dime.thema;

import com.dime.thema.feature_word.model.WordResponse;
import com.dime.thema.feature_word.services.impl.WordServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration
class WordsApiClientTest {

    @Autowired
    WordServiceImpl wordServiceImpl;

    @BeforeEach
    void setUp() {
    }

    @SneakyThrows
    @Test
    void getSynonyms() {
        WordResponse wordResponse = wordServiceImpl.getSynonymsForWord("school");
        String result = wordResponse.getSynonyms().toString();
        assertThat(result).contains(Arrays.asList("shoal", "school day", "schooltime", "civilise", "civilize", "cultivate", "educate", "train", "schooling", "schoolhouse"));
    }
}
