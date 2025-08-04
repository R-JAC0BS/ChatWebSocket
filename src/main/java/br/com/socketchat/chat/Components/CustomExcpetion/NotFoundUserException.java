package br.com.socketchat.chat.Components.CustomExcpetion;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException() {
        super("Usuario não encontrado");
    }
}
