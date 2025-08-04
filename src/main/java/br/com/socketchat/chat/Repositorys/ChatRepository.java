package br.com.socketchat.chat.Repositorys;

import br.com.socketchat.chat.Entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRepository extends JpaRepository <ChatEntity, Long> {


    boolean existsById(Long chatId);
}
