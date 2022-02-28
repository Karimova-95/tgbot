package ru.skillfactory.tgbot.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactory.tgbot.entity.Spend;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class SpendDAOTest {

    @Autowired
    private SpendDAO dao;

    @Test
    @DisplayName("ALL_SPEND_test")
    public void allSpendsTest() {
        final List<Spend> found = dao.findAll();
        assertEquals(4, found.size());
    }


    @Test
    @DisplayName("SPEND_DATA_SCRIPT_test")
    void dataScriptTest() {
        Optional<Spend> spend = dao.findById(1236L);
        assertTrue(spend.isPresent());
        assertEquals(4236L, spend.get().getChatId());
    }

}