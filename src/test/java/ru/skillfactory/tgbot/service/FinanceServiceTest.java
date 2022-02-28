package ru.skillfactory.tgbot.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.skillfactory.tgbot.dao.IncomeDAO;
import ru.skillfactory.tgbot.dao.SpendDAO;
import ru.skillfactory.tgbot.entity.Income;
import ru.skillfactory.tgbot.entity.Spend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@Slf4j
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class FinanceServiceTest {

    @Mock
    private SpendDAO spendDAO;

    @Mock
    private IncomeDAO incomeDAO;

    @InjectMocks
    private FinanceService financeService;

    @BeforeEach
    void beforeAll() {
        log.info(String.valueOf(System.currentTimeMillis()));
    }

    @AfterEach
    void afterEach() {
        log.info(String.valueOf(System.currentTimeMillis()));
    }

    @DisplayName("ADD_SPEND_test")
    @Test
    void addFinanceOperationElseBranchTest() {
        String price = "200";
        String message = financeService.addFinanceOperation("/addspend", price, 250L, 123456);
        assertEquals("Расход в размере " + price + " был успешно добавлен", message);
        verify(spendDAO).save(any(Spend.class));
    }

    @DisplayName("ADD_INCOME_test")
    @ParameterizedTest
    @ValueSource(strings = {"150.0", "200.50", "199.99"})
    void addFinanceOperationAddIncomeTest(String price) {
        String message = financeService.addFinanceOperation("/addincome", price, 500L, 56789);
        assertEquals("Доход в размере " + price + " был успешно добавлен", message);
        verify(incomeDAO).save(any(Income.class));
    }

    @DisplayName("INCORRECT_INPUT_test")
    @Test
    void incorrectOperationTest() {
        String incorrectPrice = "price";
        String message = financeService.addFinanceOperation("/abcde", incorrectPrice, 100L, 1234567);
        assertEquals("Уупс! Вы ввели неверную команду!", message);
    }
}