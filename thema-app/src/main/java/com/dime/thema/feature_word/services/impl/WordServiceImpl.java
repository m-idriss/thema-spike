package com.dime.thema.feature_word.services.impl;

import com.dime.thema.ApiProperties;
import com.dime.thema.WordsCategory;
import com.dime.thema.feature_word.exception.ResourceNotFoundException;
import com.dime.thema.feature_word.model.WordResponse;
import com.dime.thema.feature_word.services.WordService;
import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {

    private final ApiProperties apiProperties;

    @Override
    public WordResponse getSynonymsForWord(String word) throws ResourceNotFoundException, IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://" + apiProperties.getUrl() + "/words/" + word + "/" + WordsCategory.SYNONYMS.getName())
                .get()
                .addHeader("x-rapidapi-host", apiProperties.getUrl())
                .addHeader("x-rapidapi-key", apiProperties.getKey())
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return new Gson().fromJson(response.body().string(), WordResponse.class);
        } else {
            throw new ResourceNotFoundException(WordsCategory.SYNONYMS.getName(), word);
        }
    }
}
