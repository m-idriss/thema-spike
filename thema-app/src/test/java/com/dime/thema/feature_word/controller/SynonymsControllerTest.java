package com.dime.thema.feature_word.controller;

import com.dime.thema.feature_word.exception.ResourceNotFoundException;
import com.dime.thema.feature_word.model.WordResponse;
import com.dime.thema.feature_word.services.WordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SynonymsController.class)
@WithMockUser(roles = "USER") // Add this annotation to authenticate the test with the specified role
class SynonymsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ModelMapper mockModelMapper;
    @MockBean
    private WordService mockWordService;

    @Test
    @DisplayName("test Get Synonyms For Word")
    void testGetSynonymsForWord() throws Exception {
        // Setup
        // Configure WordService.getSynonymsForWord(...).
        final WordResponse wordResponse = new WordResponse();
        wordResponse.setWord("word");
        wordResponse.setSynonyms(List.of("value"));
        when(mockWordService.getSynonymsForWord("word")).thenReturn(wordResponse);

        // Configure ModelMapper.map(...).
        final WordResponse wordResponse1 = new WordResponse();
        wordResponse1.setWord("word");
        wordResponse1.setSynonyms(List.of("value"));
        when(mockModelMapper.map(any(Object.class), eq(WordResponse.class))).thenReturn(wordResponse1);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/rest/synonyms/{word}", "word")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(wordResponse.getWord()).isEqualTo("word");
        assertThat(wordResponse.getSynonyms()).isEqualTo(List.of("value"));
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("{\"word\":\"word\",\"synonyms\":[\"value\"]}");
    }

    @Test
    @DisplayName("test Get Synonyms For Word throws ResourceNotFoundException")
    void testGetSynonymsForWord_WordServiceThrowsResourceNotFoundException() throws Exception {
        // Setup
        when(mockWordService.getSynonymsForWord("word")).thenThrow(ResourceNotFoundException.class);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/rest/synonyms/{word}", "word")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.NOT_FOUND.value());
        assertThat(response.getContentAsString()).contains("message", "timestamp", "code", "404");
    }

}
