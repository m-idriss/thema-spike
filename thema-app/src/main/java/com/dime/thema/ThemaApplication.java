package com.dime.thema;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@Slf4j
public class ThemaApplication {

    public static final String SERVER_PORT = "server.port";

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(final String[] args) throws UnknownHostException {
        var app = new SpringApplication(ThemaApplication.class);
        final Environment env = app.run(args).getEnvironment();
        var protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        log.info("\n");
        log.info("""
                                
                         ----------------------------------------------------------
                        \t Application '{}' is running!
                        \t Access URLs:
                        \t - Local: \t\t{}://localhost:{}
                        \t - External: \t{}://{}:{}
                        \t Swagger UI: \t{}://localhost:{}/swagger-ui.html
                        \t Profile(s): \t{}
                         ----------------------------------------------------------
                        """,
                //
                env.getProperty("spring.application.name"),
                protocol, env.getProperty(SERVER_PORT),
                protocol, InetAddress.getLocalHost().getHostAddress(), env.getProperty(SERVER_PORT),
                protocol, env.getProperty(SERVER_PORT),
                env.getActiveProfiles());
    }
}
