package ru.skillfactory.tgbot.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactory.tgbot.entity.Income;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class IncomeDAOTest {

    @Autowired
    private IncomeDAO dao;

    @Test
    @DisplayName("ALL_INCOME_test")
    public void allIncomesTest() {
        final List<Income> found = dao.findAll();
        assertEquals(8, found.size());
    }

    @Test
    @DisplayName("INCOME_DATA_SCRIPT_test")
    public void dataScriptTest() {
        Optional<Income> income = dao.findById(6789L);
        assertTrue(income.isPresent());
        assertEquals(12345, income.get().getChatId());
    }
}