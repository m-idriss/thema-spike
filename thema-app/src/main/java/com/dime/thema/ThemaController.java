package com.dime.thema;

import com.dime.thema.feature_word.model.WordResponse;
import com.google.gson.Gson;
import com.squareup.okhttp.ResponseBody;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Getter
@CrossOrigin
@RestController
public class ThemaController {

    private final Gson gson;
    private final ApiClientFactory apiClientFactory;

    @Autowired
    public ThemaController(Gson gson, ApiClientFactory apiClientFactory) {
        this.gson = gson;
        this.apiClientFactory = apiClientFactory;
    }

    @GetMapping("/synonyms/{word}")
    public String getSynonyms(@PathVariable("word") String word) throws IOException {
        return getGson().toJson(getResultFromApi(apiClientFactory.getInstance().getSynonyms(word)).getSynonyms());
    }

    @GetMapping("/example/{word}")
    public String getExamples(@PathVariable("word") String word) throws IOException {
        return getGson().toJson(getResultFromApi(apiClientFactory.getInstance().getExamples(word)).getExamples());
    }

    private WordResponse getResultFromApi(ResponseBody responseBody) throws IOException {
        return getGson().fromJson(responseBody.string(), WordResponse.class);
    }

}
