package com.natan.chatbot.Controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.*;
import com.mashape.unirest.http.exceptions.*;
import com.natan.chatbot.Models.*;
import com.natan.chatbot.Models.Bot.*;
import com.natan.chatbot.Services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/bot")
public class BotController {

    @Autowired
    AmazonService amazonService;

    @Autowired
    KspService kspService;

    /**
     *
     * @param keyword - the keyword to search for
     * @return - a list of products from amazon
     * @throws IOException
     */
    @GetMapping("/amazon")
    public ResponseEntity<?> getProducts(@RequestParam String keyword) throws IOException {
        return ResponseEntity.ok(amazonService.searchProducts(keyword));
    }
    @Autowired
    private ObjectMapper objectMapper;


    /**
     * note: this block when we running in deploy mode
     * @param keyword - the keyword to search for
     * @return - a list of products
     */

    @GetMapping("/ksp")
    public ResponseEntity<?> getKspProducts1(@RequestParam String keyword) {

        ArrayList<KspResponse.KspItem> kspItems = null;

        try {
            kspItems = kspService.kspScrap(keyword);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(kspItems);
    }


    @GetMapping("/ksp-bot")
    public ResponseEntity<?> kspBot(@RequestParam String keyword) {

        ArrayList<KspResponse.KspItem> kspItems = null;
        String response = null;
        try {
           response= kspService.kspScrapBot(keyword);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(response);
    }



    /**
     * @param query the query to be sent to the bot
     * @return the response from the bot
     */
    @PostMapping("")
    public ResponseEntity<?> getBotResponse(@RequestBody BotQuery query) {
        HashMap<String, String> params = query.getQueryResult().getParameters();
//        Map<Integer, KspItem> amazonItemMap = new HashMap<>();
        Map<Integer, AmazonItem> amazonItemMap = new HashMap<>();
        String response = "";
        if (params.containsKey("product")) {
            //                amazonItemMap = kspService.searchProductInKSP(params.get("product"));
            try {
//                amazonItemMap = amazonService.searchProducts(params.get("product"));
//                response = amazonService.searchProducts(params.get("product"));
                String s = objectMapper.writeValueAsString(kspService.kspScrap(params.get("product")));
                response = objectMapper.readValue(s, String.class);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(BotResponse.of(response), HttpStatus.OK);
    }


}
