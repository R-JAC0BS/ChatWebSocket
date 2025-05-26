package br.com.socketchat.chat.Services;


import br.com.socketchat.chat.Entity.Greeting;
import br.com.socketchat.chat.Entity.MessageEntity;
import br.com.socketchat.chat.Repositorys.MessageRepository;
import br.com.socketchat.chat.Repositorys.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MessageService {


    private final MessageRepository messageRepository;
    private final UserRepository userRepository;


    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }

    public void SaveMessage(Greeting greeting) throws Exception{
        String username = String.valueOf(userRepository.findByusername(String.valueOf(greeting.getUsername())));

        MessageEntity messageEntity = new MessageEntity();
        System.out.println("salvando mensagem: " + greeting.getContent());
        messageEntity.setId(null);
        messageEntity.setContent(greeting.getContent());
        messageEntity.setSender(greeting.getUsername());
        messageEntity.setTimestamp(LocalDateTime.now());

        messageRepository.save(messageEntity);


    }


}
