package com.dime.thema.words;

import com.dime.thema.entity.LogApi;
import com.dime.thema.service.LogApiService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("WordsApiClient")
public class WordsApiClient implements IApiClient {

    private final ApiProperties apiProperties;
    private final LogApiService logApiService;

    @Autowired
    public WordsApiClient(ApiProperties apiProperties, LogApiService logApiService) {
        this.apiProperties = apiProperties;
        this.logApiService = logApiService;
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
        Response response = client.newCall(request).execute();
        logApiService.saveResponse(apiProperties.getName(), request.urlString(), response.code());
        return response.body();
    }
}
