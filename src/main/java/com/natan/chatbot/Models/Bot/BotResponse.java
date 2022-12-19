package com.natan.chatbot.Models.Bot;

import com.natan.chatbot.Models.*;

import java.util.*;

public class BotResponse {
    String fulfillmentText;
    Map<Integer, AmazonItem> amazonItemMap;
    //        Map<Integer, KspItem> kspItemMap;
    String source = "BOT";

    public Map<Integer, AmazonItem> getKspItemMap() {

        return amazonItemMap;
    }

    public String getFulfillmentText() {
        return fulfillmentText;
    }

    public String getSource() {
        return source;
    }

    public static BotResponse of(String fulfillmentText) {
        BotResponse botResponse = new BotResponse();
//        botResponse.amazonItemMap = map;
        botResponse.fulfillmentText = fulfillmentText;
        return botResponse;
    }
}