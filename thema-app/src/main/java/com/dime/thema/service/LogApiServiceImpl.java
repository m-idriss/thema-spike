package com.dime.thema.service;

import com.dime.thema.entity.LogApi;
import com.dime.thema.repository.LogApiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogApiServiceImpl implements LogApiService {

    @Autowired
    private LogApiRepository logApiRepository;

    @Override
    public Iterable<LogApi> findAll() {
        return logApiRepository.findAll();
    }

    @Override
    public void save(LogApi logApi) {
        logApiRepository.save(logApi);
    }

    @Override
    public void saveResponse(String name, String url, int code) {
        LogApi logApi = new LogApi();
        logApi.setName(name);
        logApi.setUrl(url);
        logApi.setCode(code);
        logApiRepository.save(logApi);
    }

}
