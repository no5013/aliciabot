package com.slack.slackbot.model.chat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class PostMessage {
    private String text;
    private String channel;
}
