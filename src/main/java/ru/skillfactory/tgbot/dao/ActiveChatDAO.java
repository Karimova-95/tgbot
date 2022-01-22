package ru.skillfactory.tgbot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skillfactory.tgbot.entity.ActiveChat;

import java.util.Optional;

@Repository
public interface ActiveChatDAO extends JpaRepository<ActiveChat, Long> {
    Optional<ActiveChat> findActiveChatByChatId(Long chatId);
}
