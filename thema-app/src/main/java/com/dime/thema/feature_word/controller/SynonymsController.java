package com.dime.thema.feature_word.controller;

import com.dime.thema.feature_word.exception.ResourceNotFoundException;
import com.dime.thema.feature_word.model.WordResponse;
import com.dime.thema.feature_word.services.WordService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/rest/synonyms")
//@Secured("ROLE_USER")
public class SynonymsController {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private WordService wordService;

    @Operation(summary = "Get a synonyms for word")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200",
                            description = "Found the synonyms",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = WordResponse.class))}),
                    @ApiResponse(responseCode = "404",
                            description = "Synonyms not found",
                            content = @Content)})
    @GetMapping("/{word}")
    public ResponseEntity<WordResponse> getSynonymsForWord(@PathVariable("word") String word) throws ResourceNotFoundException, IOException {
        WordResponse synonyms = wordService.getSynonymsForWord(word);
        WordResponse synonymsResponse = modelMapper.map(synonyms, WordResponse.class);
        return new ResponseEntity<>(synonymsResponse, HttpStatus.OK);
    }

}
