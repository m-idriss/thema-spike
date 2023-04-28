package com.dime.thema.feature_word.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WordResponse {

    private String word;

    private List<String> synonyms;
}
