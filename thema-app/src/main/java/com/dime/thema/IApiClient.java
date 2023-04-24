package com.dime.thema;

import okhttp3.ResponseBody;

import java.io.IOException;


public interface IApiClient {

    ResponseBody getSynonyms(String word) throws IOException;

    ResponseBody getExamples(String word) throws IOException;
}
