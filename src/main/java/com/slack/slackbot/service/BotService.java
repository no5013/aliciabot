package com.slack.slackbot.service;

import com.slack.slackbot.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BotService {
    @Autowired
    private SlackService slackService;

    public void botReact(Event event){
        if(event.getEvent().getType().equals("app_mention")){
            String text = event.getEvent().getText();
            if (text.contains("Hello")) {
                // Make call to chat.postMessage using bot's token
                slackService.sendMessage(event.getToken(), event.getEvent().getChannel(), String.format("Hello %s", event.getEvent().getUser()));
            }
        }
    }
}
