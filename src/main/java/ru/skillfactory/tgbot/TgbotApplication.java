package ru.skillfactory.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.skillfactory.tgbot.config.BotApiKeyProperties;
import ru.skillfactory.tgbot.config.BotNameProperties;
import ru.skillfactory.tgbot.config.CbrApiUrlProperties;

@EnableScheduling
@SpringBootApplication
@EnableConfigurationProperties({BotApiKeyProperties.class, BotNameProperties.class, CbrApiUrlProperties.class})
public class TgbotApplication {

    public static void main(String[] args) {
        SpringApplication.run(TgbotApplication.class, args);
    }

}
