package com.slack.slackbot.interceptor;

import com.slack.slackbot.config.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@Slf4j
public class BearerAuthInterceptor implements ClientHttpRequestInterceptor {
    private static final String BEARER = "Bearer ";

    private String token;

    public BearerAuthInterceptor(String token){
        this.token = token;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        httpRequest.getHeaders().set(CommonConstant.AUTHORIZATION_HEADER_KEY, BEARER+this.token);
        log.info("{}", httpRequest.getHeaders());
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest, bytes);
        return response;
    }
}
