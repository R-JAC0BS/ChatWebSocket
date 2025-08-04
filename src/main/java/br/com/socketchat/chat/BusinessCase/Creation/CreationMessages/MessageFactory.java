package br.com.socketchat.chat.BusinessCase.Creation.CreationMessages;

import br.com.socketchat.chat.Entity.ChatEntity;
import br.com.socketchat.chat.Entity.Greeting;
import br.com.socketchat.chat.Entity.MessageEntity;
import br.com.socketchat.chat.Repositorys.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service("MessageFactory")
public class MessageFactory implements CreationMessageFactory {


    private final ChatRepository chatRepository;

    public MessageFactory(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public MessageEntity manipuleMessageFactory(Greeting greeting, Long id) throws Exception {

        ChatEntity chat = chatRepository.findById(id).orElseThrow(() -> new Exception("Chat não encontrado com ID: " + id));
        MessageEntity messageEntity = new MessageEntity(
                                                        greeting.getContent(),
                                                        greeting.getUsername(),
                                                        LocalDateTime.now());
        messageEntity.setChat(chat);
        chat.adicionarMensagem(messageEntity);

        return messageEntity;
    }

}
