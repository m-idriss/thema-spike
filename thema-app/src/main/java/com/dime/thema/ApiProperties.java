package com.dime.thema;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Getter
@Setter
@PropertySource("classpath:parameters/wordsapi.properties")
@ConfigurationProperties(prefix = "wordsapi.host")
@Component
public class ApiProperties {

    private String url;
    private String key;
}
