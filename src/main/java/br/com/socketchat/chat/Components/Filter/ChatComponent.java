package br.com.socketchat.chat.Components.Filter;

import br.com.socketchat.chat.Components.CustomErrors.CustomUserError.ValidacaoException;
import br.com.socketchat.chat.Components.CustomExcpetion.ChatNotFoundOrUnathourizedExpection;
import br.com.socketchat.chat.Components.CustomExcpetion.NotFoundUserException;
import br.com.socketchat.chat.DTO.ErroValidacaoDTO;
import br.com.socketchat.chat.Entity.ChatEntity;
import br.com.socketchat.chat.Repositorys.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatComponent {

    private static ChatRepository chatRepository;

    @Autowired
    public ChatComponent(ChatRepository chatRepository) {
        ChatComponent.chatRepository = chatRepository;
    }

    public static ChatEntity findChat(Long id) {
        return chatRepository.findById(id)
                .orElseThrow(NotFoundUserException::new);
    }

    public static ChatEntity findChatById (Long id) {
        return chatRepository.findById(id).orElseThrow(() -> new ValidacaoException(new ErroValidacaoDTO("Chat com esse id não encontrado")));
    }

    public static ChatEntity removerUserInChat(Long id, String email) {
        return chatRepository.findById(id)
                .map(chat -> {
                    if (!chat.getUsersConnectTochat().contains(email)) {
                        throw new ValidacaoException(new ErroValidacaoDTO("Está conta não está no chat"));
                    }
                    chat.getUsersConnectTochat().removeIf(user -> user.equals(email));
                    return chat;
                })
                .orElseThrow(NotFoundUserException::new);
    }

    public static void deleteChat (Long id) {
        chatRepository.deleteById(id);
    }


    public static void saveChat(ChatEntity chat) {
        chatRepository.save(chat);
    }
}
