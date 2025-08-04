package br.com.socketchat.chat.Services;

import br.com.socketchat.chat.BusinessCase.Creation.CreationChatAndToAdd.JoinToChat;
import br.com.socketchat.chat.BusinessCase.Removes.ExitChat.ExitChat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class ChatConnectedService {

    @Autowired
    @Qualifier("JoinChatFactory")
    private JoinToChat joinToChat;


    @Autowired
    @Qualifier("exitChatFactory")
    private ExitChat exitChat;


    public void jointToChat(Long entrar_em_um_chat,String emailDoUsuarioo) {
        joinToChat.joinToChat(entrar_em_um_chat,emailDoUsuarioo);
    }

    public void exitChat(Long idChat, String emailDoUsuarioo) {
        exitChat.exitChat(idChat,emailDoUsuarioo);
    }


}
