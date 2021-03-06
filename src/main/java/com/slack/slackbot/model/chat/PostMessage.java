package com.slack.slackbot.model.chat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class PostMessage {
    private String text;
    private String channel;
    private List<Attachment> attachments = new ArrayList<>();
}
