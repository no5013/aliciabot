package com.slack.slackbot.service;

import com.slack.slackbot.model.Event;
import com.slack.slackbot.model.chat.Attachment;
import com.slack.slackbot.model.chat.PostMessage;
import com.slack.slackbot.model.shop.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotService {
    @Autowired
    private SlackService slackService;
    @Autowired
    private FoodService foodService;

    public void botReact(Event event){
        if(event.getEvent().getType().equals("app_mention")){
            String text = event.getEvent().getText();
            if (text.contains("สุ่ม")) {
                String message = "กิน ";
                PostMessage postMessage = new PostMessage();
                postMessage.setChannel(event.getEvent().getChannel());
                Shop shop = foodService.randomShop();
                while (shop.isHate())
                    message += String.format("~%s~ ", shop.toString());

                message += shop.toString();
                postMessage.setText(message);
                slackService.sendMessage(postMessage);
            }

            if (text.contains("กิน") && text.contains("ไร")){
                PostMessage postMessage = new PostMessage();
                postMessage.setChannel(event.getEvent().getChannel());
                postMessage.setText("กินไรกันดี");
                List<Shop> shopList = foodService.listShop();
                for(int i=0; i<shopList.size(); i++){
                    Shop shop = shopList.get(i);
                    Attachment attachment = new Attachment();
                    attachment.setColor(Attachment.colorList.get(i % Attachment.colorList.size()));
                    attachment.setText(shop.toString());
                    postMessage.getAttachments().add(attachment);
                }
                slackService.sendMessage(postMessage);
            }
        }
    }
}
