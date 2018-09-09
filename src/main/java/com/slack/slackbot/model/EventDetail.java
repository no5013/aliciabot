package com.slack.slackbot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EventDetail {
    private String type;
    private String user;
    private String text;
    private String ts;
    private String channel;
    private String event_is;
}
