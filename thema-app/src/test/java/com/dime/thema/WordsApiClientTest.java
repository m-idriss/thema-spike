package com.dime.thema;

import com.google.gson.Gson;
import com.squareup.okhttp.ResponseBody;
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
    WordsApiClient wordsApiClient;

    @BeforeEach
    void setUp() {
    }

    @SneakyThrows
    @Test
    void getSynonyms() {

        ResponseBody responseBody = wordsApiClient.getSynonyms("school");
        WordsApiResponse entity = new Gson().fromJson(responseBody.string(), WordsApiResponse.class);
        String result = entity.getSynonyms().toString();
        assertThat(result).contains(Arrays.asList("shoal", "school day", "schooltime", "civilise", "civilize", "cultivate", "educate", "train", "schooling", "schoolhouse"));
    }
}