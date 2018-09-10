package com.slack.slackbot.controller;

import com.slack.slackbot.model.Event;
import com.slack.slackbot.service.BotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BotController {
    @Autowired
    private BotService botService;

    @PostMapping("/slackbot/events")
    public ResponseEntity<?> postEvent(@RequestBody Event event){
        log.info("{}", event);
        if(event.getEvent() != null)
            botService.botReact(event);
        return new ResponseEntity<>(event, HttpStatus.OK);
    }
}
