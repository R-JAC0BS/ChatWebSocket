package br.com.socketchat.chat.BusinessCase.Creation.CreationChatAndToAdd;


import br.com.socketchat.chat.Components.Filter.UserComponent;
import br.com.socketchat.chat.Entity.ChatEntity;
import br.com.socketchat.chat.Entity.UserEntity;
import br.com.socketchat.chat.Repositorys.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("CreateChat")
public class CreateNewChat implements ChatCreation {


    @Autowired
    UserComponent userComponent;
    @Autowired
    ChatRepository chatRepository;

    @Override
    public ChatEntity criarChat(String nomeChat, String email) throws Exception {
        ChatEntity chatEntity = new ChatEntity(nomeChat,email);
        UserEntity user = userComponent.findUser(email);
        user.getChats().add(chatEntity);
        chatEntity.getUsers().add(user);
        chatRepository.save(chatEntity);
        userComponent.saveUser(user);
        return chatEntity;
    }
}