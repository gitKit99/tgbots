package com.tgbots.savchtgbots;

import com.tgbots.savchtgbots.service.BotsService;
import com.tgbots.savchtgbots.titiko.TitikoBot;
import com.tgbots.savchtgbots.titiko.TitikoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Configuration
@PropertySource("tokens.properties")
@SpringBootApplication(scanBasePackages = "com.tgbots.savchtgbots")
public class SavchTgBotsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SavchTgBotsApplication.class, args);
        context.getBean(BotsService.class).registerBots();
    }

}
