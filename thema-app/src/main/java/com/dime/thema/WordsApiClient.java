package com.dime.thema;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("WordsApiClient")
public class WordsApiClient implements IApiClient {

    private final ApiProperties apiProperties;

    @Autowired
    public WordsApiClient(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }

    @Override
    public ResponseBody getSynonyms(String word) throws IOException {
        return getResponseBodyFromWordsApi(word, WordsCategory.SYNONYMS);
    }

    @Override
    public ResponseBody getExamples(String word) throws IOException {
        return getResponseBodyFromWordsApi(word, WordsCategory.EXAMPLES);
    }

    private ResponseBody getResponseBodyFromWordsApi(String word, WordsCategory category) throws IOException {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://" + apiProperties.getUrl() + "/words/" + word + (category != WordsCategory.EVERYTHING ? "/" + category.getName() : ""))
                .get()
                .addHeader("x-rapidapi-host", apiProperties.getUrl())
                .addHeader("x-rapidapi-key", apiProperties.getKey())
                .build();

        return client.newCall(request).execute().body();
    }
}
