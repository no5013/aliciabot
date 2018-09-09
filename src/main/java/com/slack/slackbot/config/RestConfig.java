package com.slack.slackbot.config;

import com.slack.slackbot.interceptor.BearerAuthInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestConfig {

    @Value("${slack.bot.token}")
    private String slackBotToken;

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(
                Collections.singletonList(bearerAuthInterceptor())
        );
        return restTemplate;
    }

    @Bean
    @Scope("request")
    public HttpHeaders httpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }

    @Bean
    public BearerAuthInterceptor bearerAuthInterceptor(){
        return new BearerAuthInterceptor(slackBotToken);
    }
}