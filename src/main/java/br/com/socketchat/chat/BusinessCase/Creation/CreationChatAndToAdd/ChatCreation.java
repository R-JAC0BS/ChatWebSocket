package br.com.socketchat.chat.BusinessCase.Creation.CreationChatAndToAdd;

import br.com.socketchat.chat.Entity.ChatEntity;

public interface ChatCreation {
     ChatEntity criarChat (String nomeChat, String email) throws Exception;
}
