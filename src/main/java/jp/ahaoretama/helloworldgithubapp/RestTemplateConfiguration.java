package jp.ahaoretama.helloworldgithubapp;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aha-oretama
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        HeaderRequestInterceptor headerRequestInterceptor = new HeaderRequestInterceptor("Accept", "application/vnd.github.machine-man-preview+json");
        LoggingRequestInterceptor loggingRequestInterceptor = new LoggingRequestInterceptor();

        return builder
                .requestFactory(() -> new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()))
                .interceptors(headerRequestInterceptor, loggingRequestInterceptor)
                .build();
    }
}
