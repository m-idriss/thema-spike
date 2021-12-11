package com.dime.thema;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@Component
public class ApiClientFactory {

    @Qualifier("WordsApiClient")
    private final IApiClient instance;

    @Autowired
    public ApiClientFactory(IApiClient iApiClient) {
        this.instance = iApiClient;
    }
}
