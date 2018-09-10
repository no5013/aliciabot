package com.slack.slackbot.model.shop;

import lombok.*;

@Data
@AllArgsConstructor
public class Shop {
    private String thaiName;
    private String engName;

    @Override
    public String toString(){
        return thaiName + " // " + engName;
    }
}
