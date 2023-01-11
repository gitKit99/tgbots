package com.tgbots.savchtgbots.titiko;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TitikoBot extends TelegramLongPollingBot {

    private static final String TIKTOK_PREFIX = "https://vm.tiktok.com/";

    private final String userName = "titiko_bot";
    private String secretToken;

    public TitikoBot( String secretToken ) {
        this.secretToken = secretToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }
        String receivedMsg = update.getMessage().getText();
        if (receivedMsg.startsWith(TIKTOK_PREFIX)) {
            long chatId = update.getMessage().getChatId();

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("It is a tiktok link!");

            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return this.userName;
    }

    @Override
    public String getBotToken() {
        return this.secretToken;
    }
}
