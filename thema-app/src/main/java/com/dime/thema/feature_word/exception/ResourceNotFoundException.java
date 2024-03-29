package com.dime.thema.feature_word.exception;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends Exception {
    private final String type;
    private final String word;

    public ResourceNotFoundException(String type, String word) {
        super(String.format("%s not found for : %s", type, word));
        this.type = type;
        this.word = word;
    }

}
