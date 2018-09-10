package com.slack.slackbot.service;

import com.slack.slackbot.model.shop.Shop;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FoodService {

    private List<Shop> shops = Arrays.asList(
            new Shop("แคนทืันชั้น2", "second floor", true),
            new Shop("เมเจอร์", "Major cineplex"),
            new Shop("ส้มตำส้มตำ", "Som tam"),
            new Shop("เตี๋ยวเรือ", "Noodle (Next to Som tam)"),
            new Shop("เต็นท์ร้อน", "Foodcourt Boxspace"),
            new Shop("เบทาโกร", "Betagro", true),
            new Shop("เล้ง", "Leng"),
            new Shop("หมูกรอบ", "Crispy Pork")
    );

    public Shop randomShop(){
        Collections.shuffle(shops);
        return shops.get(0);
    }

    public List<Shop> listShop(){
        return shops;
    }
}
