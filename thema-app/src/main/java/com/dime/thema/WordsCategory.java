package com.dime.thema;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WordsCategory {

    EVERYTHING(""),
    SYNONYMS("synonyms"),
    EXAMPLES("examples");

    private final String name;
}
