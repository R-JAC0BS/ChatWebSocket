package br.com.socketchat.chat.Components.CustomExcpetion;

public class ChatNotFoundOrUnathourizedExpection extends RuntimeException {
    public ChatNotFoundOrUnathourizedExpection() {
        super("Chat Não encontrado ou usuario não é administrador do chat");
    }
}
