package com.dime.thema;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WordsApiResponse {

    private String word;

    private List<String> synonyms;

    private List<String> examples;
}