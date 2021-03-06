package com.dime.thema.words;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;


public interface IApiClient {

    ResponseBody getSynonyms(String word) throws IOException;

    ResponseBody getExamples(String word) throws IOException;
}
