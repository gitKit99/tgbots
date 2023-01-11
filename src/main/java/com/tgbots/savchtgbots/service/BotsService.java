package com.tgbots.savchtgbots.service;

import com.tgbots.savchtgbots.titiko.TitikoBot;
import com.tgbots.savchtgbots.titiko.TitikoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Service
public class BotsService {

    private final TitikoService titikoService;

    @Autowired
    public BotsService( TitikoService titikoService ) {
        this.titikoService = titikoService;
    }

    public void registerBots() {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TitikoBot( titikoService.getToken() ));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
