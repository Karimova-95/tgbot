package ru.skillfactory.tgbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactory.tgbot.dao.IncomeDAO;
import ru.skillfactory.tgbot.dao.SpendDAO;
import ru.skillfactory.tgbot.entity.Income;
import ru.skillfactory.tgbot.entity.Spend;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class FinanceService {

    private static final String ADD_INCOME = "/addincome";

    private final IncomeDAO incomeDAO;
    private final SpendDAO spendDAO;


    public String addFinanceOperation(String operationType, String price, Long chatId) {
        String message;
        if (ADD_INCOME.equalsIgnoreCase(operationType)) {
            Income income = new Income();
            income.setChatId(chatId);
            income.setIncome(new BigDecimal(price));
            incomeDAO.save(income);
            message = "Доход в размере " + price + " был успешно добавлен";
        } else {
            Spend spend = new Spend();
            spend.setChatId(chatId);
            spend.setSpend(new BigDecimal(price));
            spendDAO.save(spend);
            message = "Расход в размере " + price + " был успешно добавлен";
        }
        return message;
    }
}