package ru.skillfactory.tgbot.web;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/getCurrencies")
    public List<ValuteCursOnDate> getValuteCursOnDate() throws Exception {
        return centralRussianBankService.getCurrenciesFromCbr();
    }

    @GetMapping("/getGreatStats")
    @ApiOperation(value = "Получение количества пополнений, которые превышают определенную сумму")
    public int getStatsAboutStatsThatGreater(@RequestParam(value = "amount") BigDecimal amount) {
        return statService.getCountIfIncomesThatGreater(amount);
    }

    @GetMapping("/getLessStats")
    @ApiOperation(value = "Получение количества пополнений, которые превышают определенную сумму")
    public int getStatsAboutStatsThatLess(@RequestParam(value = "amount") BigDecimal amount) {
        return statService.getCountIfIncomesThatLess(amount);
    }
}
