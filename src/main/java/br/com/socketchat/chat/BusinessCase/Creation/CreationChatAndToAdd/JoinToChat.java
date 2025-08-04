package br.com.socketchat.chat.BusinessCase.Creation.CreationChatAndToAdd;

import br.com.socketchat.chat.Components.CustomErrors.CustomUserError.ValidacaoException;
import br.com.socketchat.chat.Components.Filter.ChatComponent;
import br.com.socketchat.chat.Components.Filter.UserComponent;
import br.com.socketchat.chat.DTO.ErroValidacaoDTO;
import br.com.socketchat.chat.Entity.ChatEntity;
import br.com.socketchat.chat.Entity.UserEntity;
import br.com.socketchat.chat.Strategy.ChatValidation.ChatValidation;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("JoinChatFactory")
public class JoinToChat implements JoinChat{
    @Override
    public void joinToChat(Long idChat, String email) {
         ChatValidation.tamanhoChat(idChat);
         UserEntity user = UserComponent.findUser(email);
         ChatEntity chat = ChatComponent.findChat(idChat);
         for (ChatEntity c : user.getChats()){
             if (c.getId().equals(idChat)) {
                 throw new ValidacaoException(new ErroValidacaoDTO("usuario já está presenta no chat"));
             };
         }
         List<String> usersInChat = chat.getUsersConnectTochat();
         List<ChatEntity> chatAddUser = user.getChats();
         usersInChat.add(email);
         chatAddUser.add(chat);
         UserComponent.saveUser(user);
    }
}
