package ru.skillfactory.tgbot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillfactory.tgbot.entity.Income;

@Repository
public interface IncomeDAO extends JpaRepository<Income, Long> {
}
