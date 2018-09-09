package com.slack.slackbot.service;

import com.slack.slackbot.config.CommonConstant;
import com.slack.slackbot.model.chat.PostMessage;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class SlackService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${slack.postmessage.url}")
    private String postMessageUrl;

    public String sendMessage(String botToken, String channel, String message){
        PostMessage postMessage = new PostMessage();
        postMessage.setText(message);
        postMessage.setChannel(channel);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        log.info("{}", httpHeaders);

        HttpEntity<PostMessage> request = new HttpEntity<>(postMessage, httpHeaders);
        ResponseEntity<String> response = restTemplate.postForEntity(postMessageUrl, request, String.class);
        log.info("Response: {}", response.getBody());
        return response.getBody();
    }
}
