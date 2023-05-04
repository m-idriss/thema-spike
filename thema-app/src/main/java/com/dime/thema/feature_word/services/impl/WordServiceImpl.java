package com.dime.thema.feature_word.services.impl;

import com.dime.thema.feature_word.exception.ResourceNotFoundException;
import com.dime.thema.feature_word.model.Word;
import com.dime.thema.feature_word.model.WordResponse;
import com.dime.thema.feature_word.repository.WordRepository;
import com.dime.thema.feature_word.services.WordService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@AllArgsConstructor
public class WordServiceImpl implements WordService {

    private WordsApiProperties apiProperties;
    private WordRepository wordRepository;

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
            Word entity = Word.builder()
                    .name(word)
                    .build();
            entity = wordRepository.save(entity);
            log.info(entity.toString());
            return new Gson().fromJson(response.body().string(), WordResponse.class);
        } else {
            throw new ResourceNotFoundException(WordsApiProperties.Category.SYNONYMS.getName(), word);
        }
    }
}
