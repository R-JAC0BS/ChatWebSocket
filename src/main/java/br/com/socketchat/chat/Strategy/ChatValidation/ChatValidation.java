package br.com.socketchat.chat.Strategy.ChatValidation;


import br.com.socketchat.chat.Components.CustomErrors.CustomUserError.ValidacaoException;
import br.com.socketchat.chat.Components.Filter.ChatComponent;
import br.com.socketchat.chat.DTO.ErroValidacaoDTO;
import br.com.socketchat.chat.Entity.ChatEntity;
public class ChatValidation{
    public static boolean tamanhoChat(Long id){
        ChatEntity chat = ChatComponent.findChat(id);
        if (chat.getUsersConnectTochat().size() > 20){
            throw new ValidacaoException(new ErroValidacaoDTO("Chat só pode ter 20 usuarios"));
        }
        return false;
    }


}
