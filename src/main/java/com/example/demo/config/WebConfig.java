package com.example.demo.config;

import com.example.demo.model.context.UserDataModel;
import com.example.demo.model.context.UserThreadLocalHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Slf4j
@Configuration
public class WebConfig {

    public static final String USER_NAME_HEADER = "X-User-Name-Header";
    public static final String USER_ID_HEADER = "X-User-Id-Header";
    public static final String USER_API_KEY_HEADER = "X-User-API-Key-Header";

    @Bean
    @Primary
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder().filter(filterFunction());
    }

    private ExchangeFilterFunction filterFunction() {
        return ExchangeFilterFunction.ofRequestProcessor(req -> {
            UserDataModel user = UserThreadLocalHolder.getUserHeader();
            if (Objects.nonNull(user)) {
                return Mono.just(ClientRequest.from(req)
                        .header(USER_NAME_HEADER, user.userName())
                        .header(USER_ID_HEADER, user.userId())
                        .header(USER_API_KEY_HEADER, user.apiKey())
                        .build());
            }
            log.atError().setMessage("User data is null from the thread local").log();
            return Mono.just(req);
        });
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}
