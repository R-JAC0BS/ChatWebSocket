package br.com.socketchat.chat.BusinessCase.Creation.CreationMessages;


import br.com.socketchat.chat.Entity.Greeting;
import br.com.socketchat.chat.Entity.MessageEntity;

public interface CreationMessageFactory  {
    MessageEntity manipuleMessageFactory (Greeting g,  Long id) throws Exception;
}
