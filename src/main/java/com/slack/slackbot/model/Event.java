package com.slack.slackbot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Event {
    private String token;
    private String team_id;
    private String api_app_id;
    private EventDetail event;
    private String type;
    private String event_id;
    private String event_time;
    private List<String> authed_users;
    private String challenge;
}
