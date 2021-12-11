package com.dime.thema;

import com.google.gson.Gson;
import com.squareup.okhttp.ResponseBody;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Getter
@RestController
public class ThemaController {

    private final Gson gson;
    private final ApiClientFactory apiClientFactory;

    @Autowired
    public ThemaController(Gson gson, ApiClientFactory apiClientFactory) {
        this.gson = gson;
        this.apiClientFactory = apiClientFactory;
    }

    @GetMapping("/getSynonyms")
    public String getSynonyms(@RequestParam(value = "word") String word) throws IOException {
        return getResultFromApi(apiClientFactory.getInstance().getSynonyms(word)).getSynonyms().toString();
    }

    @GetMapping("/getExamples")
    public String getExamples(@RequestParam(value = "word") String word) throws IOException {
        return getResultFromApi(apiClientFactory.getInstance().getExamples(word)).getExamples().toString();
    }

    private WordsApiResponse getResultFromApi(ResponseBody responseBody) throws IOException {
        return getGson().fromJson(responseBody.string(), WordsApiResponse.class);
    }
}
