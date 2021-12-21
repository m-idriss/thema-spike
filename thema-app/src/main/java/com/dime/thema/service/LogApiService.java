package com.dime.thema.service;

import com.dime.thema.entity.LogApi;

public interface LogApiService {

    Iterable<LogApi> findAll();

    void save(LogApi logApi);

    void saveResponse(String name, String url, int code);
}
