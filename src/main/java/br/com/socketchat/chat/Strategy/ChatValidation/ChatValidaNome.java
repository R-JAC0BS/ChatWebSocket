package br.com.socketchat.chat.Strategy.ChatValidation;


import br.com.socketchat.chat.Entity.ChatEntity;

public class ChatValidaNome implements ChatValidationStrategy<ChatEntity> {

    @Override
    public void validaChat(ChatEntity chatEntity) throws Exception {
        if (chatEntity.getNomeCanal().length() < 3 && chatEntity.getNomeCanal().length() > 30) {
            throw new Exception("Nome invalido : tamanho do chat é invalido");
        };
    }
}

