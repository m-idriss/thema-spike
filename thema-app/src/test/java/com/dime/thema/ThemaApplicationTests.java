package com.dime.thema;

import com.dime.thema.feature_word.services.WordService;
import com.dime.thema.feature_word.services.impl.WordsApiProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.net.UnknownHostException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ThemaApplicationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Test main")
    void testMain() throws UnknownHostException {
        ThemaApplication.main(new String[]{});
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Test load context")
    void contextLoads() {
        assertThat(context).isNotNull();
        assertThat(context.getBean(WordService.class)).isNotNull();
        assertThat(context.getBean(WordsApiProperties.class)).isNotNull();
    }
}
