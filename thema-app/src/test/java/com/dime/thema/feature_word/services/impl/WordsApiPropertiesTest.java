package com.dime.thema.feature_word.services.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@EnableConfigurationProperties(value = WordsApiProperties.class)
@TestPropertySource("classpath:private/wordsapi.properties")
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
class WordsApiPropertiesTest {

    @Autowired

    private WordsApiProperties wordsApiProperties;

    @Test
    @DisplayName("Test fill properties")
    void loadPropertiesFile_thenAllFieldsAreSet() {
        assertThat(wordsApiProperties.getUrl()).isNotNull();
        assertThat(wordsApiProperties.getUrl()).contains(".com");
        assertThat(wordsApiProperties.getKey()).isNotNull();
        assertThat(wordsApiProperties.getKey()).hasSize(50);
    }
}
