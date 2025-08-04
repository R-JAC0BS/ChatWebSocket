package br.com.socketchat.chat.BusinessCase.Creation.CreationChatAndToAdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class ChatFactory {

    @Autowired
    @Qualifier("CreateChat")
    private ChatCreation criarChat;

    @Autowired
    @Qualifier("JoinChatFactory")
    private JoinToChat joinToChat;


    public ChatCreation getStrategy (String tipo){
         return switch (tipo) {
             case "Create" -> criarChat;
             default -> throw new IllegalArgumentException("Tipo invalido");

         };
    }
}
