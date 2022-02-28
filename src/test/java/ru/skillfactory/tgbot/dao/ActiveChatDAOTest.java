package ru.skillfactory.tgbot.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactory.tgbot.entity.ActiveChat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ActiveChatDAOTest {

    @Autowired
    private ActiveChatDAO dao;

    @Test
    public void chatFoundTest() {
        Optional<ActiveChat> activeChatById = dao.findActiveChatByChatId(82345L);
        assertTrue(activeChatById.isPresent());
        assertEquals(123L, activeChatById.get().getId());
    }

    @Test
    public void chatNotFoundTest() {
        Optional<ActiveChat> activeChat = dao.findActiveChatByChatId(12345L);
        assertFalse(activeChat.isPresent());
    }
}