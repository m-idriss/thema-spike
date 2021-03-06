package com.dime.thema.words;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@PropertySource("classpath:private/wordsapi.properties")
@ConfigurationProperties(prefix = "wordsapi.host")
@Component
public class ApiProperties {

    private String url;
    private String key;
    private String name;

}
