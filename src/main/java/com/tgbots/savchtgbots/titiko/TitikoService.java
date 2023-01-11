package com.tgbots.savchtgbots.titiko;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class TitikoService {

    @Value("${tgbots.titikobot.token}")
    private String token;

    public String getToken() {
        return this.token;
    }
}
