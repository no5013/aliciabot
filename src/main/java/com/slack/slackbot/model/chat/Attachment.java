package com.slack.slackbot.model.chat;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Attachment {
    public static final List<String> colorList = Arrays.asList(
            "good",
            "warning",
            "danger",
            "#439FE"
    );

    private String color;
    private String text;
}
