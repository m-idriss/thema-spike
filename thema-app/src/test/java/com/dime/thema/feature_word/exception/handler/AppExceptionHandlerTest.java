package com.dime.thema.feature_word.exception.handler;


import com.dime.thema.feature_word.exception.ResourceNotFoundException;
import com.dime.thema.feature_word.shared.ResponseMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class AppExceptionHandlerTest {

    private AppExceptionHandler appExceptionHandler;

    @BeforeEach
    void setUp() {
        appExceptionHandler = new AppExceptionHandler();
    }

    @Test
    @DisplayName("Test handle ResourceNotFoundException")
    void testHandleResourceNotFoundException() {
        ResourceNotFoundException exception = new ResourceNotFoundException("synonym", "toto");
        assertThat(exception.getType()).isEqualTo("synonym");
        assertThat(exception.getWord()).isEqualTo("toto");

        ResponseEntity<Object> responseEntity = appExceptionHandler.entityNotFoundException(exception);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);

        ResponseMessage responseMessage = (ResponseMessage) responseEntity.getBody();
        assert responseMessage != null;
        assertThat(responseMessage).isNotNull();
        assertThat(responseMessage.getMessage()).isEqualTo("synonym not found for : toto");
        assertThat(responseMessage.getCode()).isEqualTo(404);
        assertThat(responseMessage.getTimestamp()).isInstanceOf(Date.class);
    }

}
