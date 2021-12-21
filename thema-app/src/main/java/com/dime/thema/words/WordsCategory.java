package com.dime.thema.words;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WordsCategory {

    EVERYTHING(""),
    SYNONYMS("synonyms"),
    EXAMPLES("examples");

    private String name;
}
