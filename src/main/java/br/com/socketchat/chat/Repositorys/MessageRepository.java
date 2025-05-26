package br.com.socketchat.chat.Repositorys;

import br.com.socketchat.chat.Entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    @Override
    Optional<MessageEntity> findById(Long id);



}
