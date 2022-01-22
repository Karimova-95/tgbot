package ru.skillfactory.tgbot.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.skillfactory.tgbot.dao.IncomeDAO;
import ru.skillfactory.tgbot.dao.SpendDAO;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FinanceServiceTest {

    @InjectMocks
    private FinanceService financeService;

    @Mock
    private SpendDAO spendDAO;


    @Mock
    private IncomeDAO incomeDAO;

    // запишем время, когда начался каждый тест
    @BeforeEach
    public void beforeAll() {
        System.out.println(System.currentTimeMillis());
    }

    // запишем время, когда закончился каждый тест
    @AfterEach
    public void afterEach() {
        System.out.println(System.currentTimeMillis());
    }
    // тестовый метод для первого кейса
    @DisplayName("ADD_INCOME_test")
    @Test
    public void addFinanceOperationAddIncomeTest() {
        // установили произвольное значение переменной для отправки в метод
        String price = "150.0";
        // обращаемся к методу с произвольными параметрами и сохраняем результат в переменную
        String message = financeService.addFinanceOperation("/addincome", price, 500L, 45156644);
        // убеждаемся, что получили ожидаемый результат
        Assertions.assertEquals("Доход в размере " + price + " был успешно добавлен", message);
    }

    // тестовый метод для второго кейса, всё аналогично первому, но с другими параметрами
    @DisplayName("non_ADD_INCOME_test")
    @Test
    public void addFinanceOperationElseBranchTest() {
        // снова даём значение переменной
        String price = "200";
        // снова обращаемся к методу с другими параметрами
        String message = financeService.addFinanceOperation("/nan", price, 250L, 4556662);
        // убеждаемся, что получили ожидаемый результат
        Assertions.assertEquals("Расход в размере " + price + " был успешно добавлен", message);
    }
}