package ru.skillfactory.tgbot.web;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.skillfactory.tgbot.service.BotService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc //тестируем обращение к Rest контроллерам
class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BotService botService;

    @Test
    @Disabled("NOT_WORK http://www.cbr.ru/ ")
    public void testWhenAskAboutAllCurrencies() throws Exception {
        mockMvc.perform(get("/currencies"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}