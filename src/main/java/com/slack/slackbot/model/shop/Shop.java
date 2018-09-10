package com.slack.slackbot.model.shop;

import lombok.*;

@Data
@AllArgsConstructor
public class Shop {
    private String thaiName;
    private String engName;
    private boolean hate;

    public Shop(String thaiName, String engName){
        this.thaiName = thaiName;
        this.engName = engName;
        this.hate = false;
    }

    public Shop(String thaiName, String engName, boolean hate){
        this.thaiName = thaiName;
        this.engName = engName;
        this.hate = hate;
    }

    @Override
    public String toString(){
        return thaiName + " // " + engName;
    }
}
