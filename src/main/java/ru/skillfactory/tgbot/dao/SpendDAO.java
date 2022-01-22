package ru.skillfactory.tgbot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillfactory.tgbot.entity.Spend;

@Repository
public interface SpendDAO extends JpaRepository<Spend, Long> {
}
