package ru.skillfactory.tgbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillfactory.tgbot.dao.StatsDAO;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class StatService {

    private final StatsDAO statsDAO;

    public int getCountIfIncomesThatGreater(BigDecimal amount) {
        return  statsDAO.getCountIncomesThatGreaterThan(amount);
    }

    public int getCountIfIncomesThatLess(BigDecimal amount) {
        return  statsDAO.getCountIncomesThatLessThan(amount);
    }
}
