package br.com.socketchat.chat.BusinessCase.Removes.RemoveUser;

import br.com.socketchat.chat.Components.CustomErrors.CustomUserError.ValidacaoException;
import br.com.socketchat.chat.Components.Filter.ChatComponent;
import br.com.socketchat.chat.Components.Filter.UserComponent;
import br.com.socketchat.chat.DTO.ErroValidacaoDTO;
import br.com.socketchat.chat.Entity.UserEntity;
import org.springframework.stereotype.Service;


@Service("removeUserFactory")
public class UserRemove implements RemoveUserInterface{

    @Override
    public void removeUser(Long id, String userToRemovem, String admin) {
        if (ChatComponent.findChat(id).getAdmin().equals(admin)) {
            ChatComponent.saveChat(ChatComponent.removerUserInChat(id,userToRemovem));
            UserEntity user = UserComponent.findUser(userToRemovem);
            user.getChats().removeIf(remove -> remove.getId().equals(id));
            UserComponent.saveUser(user);
        }else{
            throw new ValidacaoException(new ErroValidacaoDTO("Usuario não é doono do chat"));
        }

    }
}
