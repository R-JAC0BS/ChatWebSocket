package br.com.socketchat.chat.BusinessCase.Removes.ExitChat;

import br.com.socketchat.chat.Components.Filter.ChatComponent;
import br.com.socketchat.chat.Components.Filter.UserComponent;
import br.com.socketchat.chat.Entity.UserEntity;
import org.springframework.stereotype.Service;


@Service("exitChatFactory")
public class ExitChat implements ExitChatInterface {
    @Override
    public void exitChat(Long id, String email) {
        ChatComponent.saveChat(ChatComponent.removerUserInChat(id,email));
        UserEntity user = UserComponent.findUser(email);
        user.getChats().removeIf(remove -> remove.getId().equals(id));
        UserComponent.saveUser(user);
    }
}
