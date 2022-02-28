package ru.skillfactory.tgbot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "bot.api")
public class BotApiKeyProperties {
    String key;
}
