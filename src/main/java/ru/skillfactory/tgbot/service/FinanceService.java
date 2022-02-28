package ru.skillfactory.tgbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactory.tgbot.dao.IncomeDAO;
import ru.skillfactory.tgbot.dao.SpendDAO;
import ru.skillfactory.tgbot.entity.Income;
import ru.skillfactory.tgbot.entity.Spend;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class FinanceService {

    private static final String ADD_INCOME = "/addincome";
    private static final String ADD_SPEND = "/addspend";

    private final IncomeDAO incomeDAO;
    private final SpendDAO spendDAO;

    public String addFinanceOperation(String operationType, String price, Long chatId, Integer date) {
        String message;
        if (ADD_INCOME.equalsIgnoreCase(operationType)) {
            Income income = new Income();
            income.setChatId(chatId);
            income.setIncome(new BigDecimal(price));
            income.setDate(new Date((long) date * 1000).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            incomeDAO.save(income);
            message = "Доход в размере " + price + " был успешно добавлен";
        } else if (ADD_SPEND.equals(operationType)) {
            Spend spend = new Spend();
            spend.setChatId(chatId);
            spend.setSpend(new BigDecimal(price));
            spend.setDate(new Date((long) date * 1000).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            spendDAO.save(spend);
            message = "Расход в размере " + price + " был успешно добавлен";
        } else {
            message = "Уупс! Вы ввели неверную команду!";
        }
        return message;
    }
}