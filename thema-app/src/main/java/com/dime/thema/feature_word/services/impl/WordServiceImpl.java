package com.dime.thema.feature_word.services.impl;

import com.dime.thema.feature_word.exception.ResourceNotFoundException;
import com.dime.thema.feature_word.model.WordResponse;
import com.dime.thema.feature_word.services.WordService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {

    private final WordsApiProperties apiProperties;

    @Override
    public WordResponse getSynonymsForWord(String word) throws ResourceNotFoundException, IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://" + apiProperties.getUrl() + "/words/" + word + "/" + WordsApiProperties.Category.SYNONYMS.getName())
                .get()
                .addHeader("x-rapidapi-host", apiProperties.getUrl())
                .addHeader("x-rapidapi-key", apiProperties.getKey())
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            assert response.body() != null;
            return new Gson().fromJson(response.body().string(), WordResponse.class);
        } else {
            throw new ResourceNotFoundException(WordsApiProperties.Category.SYNONYMS.getName(), word);
        }
    }
}
