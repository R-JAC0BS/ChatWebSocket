package br.com.socketchat.chat.Services;



import br.com.socketchat.chat.Entity.Greeting;
import br.com.socketchat.chat.Entity.MessageEntity;
import br.com.socketchat.chat.Repositorys.MessageRepository;
import br.com.socketchat.chat.BusinessCase.Creation.CreationMessages.CreationMessageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;



@Service
public class MessageService {

    @Autowired
    private final MessageRepository chatRepository;

    @Qualifier("MessageFactory")
    CreationMessageFactory messageFactory;

    public MessageService( MessageRepository chatRepository1) {

        this.chatRepository = chatRepository1;
    }

    @Async
    public void saveMessage(Greeting greeting, Long id) throws Exception {
        MessageEntity chat  = messageFactory.manipuleMessageFactory(greeting,id);
        chatRepository.save(chat);
    }


}
