package br.com.socketchat.chat.Services;


import br.com.socketchat.chat.Components.CustomExcpetion.ChatNotFoundOrUnathourizedExpection;
import br.com.socketchat.chat.Components.Filter.ChatComponent;
import br.com.socketchat.chat.Components.Filter.UserComponent;
import br.com.socketchat.chat.Entity.ChatEntity;
import br.com.socketchat.chat.Repositorys.ChatRepository;
import br.com.socketchat.chat.Repositorys.ServiceImplementation;

import br.com.socketchat.chat.BusinessCase.Creation.CreationChatAndToAdd.ChatCreation;
import br.com.socketchat.chat.BusinessCase.Creation.CreationChatAndToAdd.ChatFactory;
import br.com.socketchat.chat.BusinessCase.Removes.RemoveUser.UserRemove;
import br.com.socketchat.chat.Repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ChatService implements ServiceImplementation  {



    @Autowired
    ChatRepository chatRepository;

    @Autowired
    ChatFactory joinFactory;

    @Autowired
    @Qualifier("removeUserFactory")
    UserRemove userRemove;
    @Qualifier("userComponent")
    @Autowired
    private UserComponent userComponent;

    public void criarChat(String nomeDoChat, String emailUsuario) throws Exception {
        ChatCreation chatCreationStrategy = joinFactory.getStrategy("Create");
        chatCreationStrategy.criarChat(nomeDoChat, emailUsuario);
    }

    @Override
    public void deletarChat(String admin,Long idDeletarChat){
        ChatEntity listaChat = chatRepository.findById(idDeletarChat).filter(c -> admin.equals(c.getAdmin())).orElseThrow(ChatNotFoundOrUnathourizedExpection::new);
        ChatComponent.deleteChat(listaChat.getId());
    }

    public void removeUser (Long id , String userToRemove, String admin){
        userRemove.removeUser(id, userToRemove, admin);
    }

    @Override
    @Transactional
    public List<ChatEntity> listarChat(String admin) {
        return UserComponent.findUser(admin).getChats();
    }

    @Transactional
    public ChatEntity findChatByID(Long id) {
        return ChatComponent.findChatById(id);
    }


}
