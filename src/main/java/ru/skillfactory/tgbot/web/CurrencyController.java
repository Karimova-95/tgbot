package ru.skillfactory.tgbot.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skillfactory.tgbot.dto.ValuteCursOnDate;
import ru.skillfactory.tgbot.service.CentralRussianBankService;
import ru.skillfactory.tgbot.service.StatService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CentralRussianBankService centralRussianBankService;
    private final StatService statService;

    @GetMapping("/currencies")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/currencies/{code}")
    @ApiOperation(value = "Получение курса определенной валюты на текущий день")
    public ValuteCursOnDate getValuteCursOnDateByCode(@PathVariable String code) throws Exception {
        return centralRussianBankService.getCurrencyByCodeFromCbr(code);
    }

    @GetMapping("/greater")
    @ApiOperation(value = "Получение количества пополнений, которые превышают определенную сумму")
    public int getStatsAboutStatsThatGreater(@RequestParam(value = "amount") BigDecimal amount) {
        return statService.getCountIfIncomesThatGreater(amount);
    }

    @GetMapping("/less")
    @ApiOperation(value = "Получение количества пополнений, которые меньше определенной суммы")
    public int getStatsAboutStatsThatLess(@RequestParam(value = "amount") BigDecimal amount) {
        return statService.getCountIfIncomesThatLess(amount);
    }
}
