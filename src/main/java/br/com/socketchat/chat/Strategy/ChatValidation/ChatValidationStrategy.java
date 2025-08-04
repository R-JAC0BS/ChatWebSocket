package br.com.socketchat.chat.Strategy.ChatValidation;



public interface ChatValidationStrategy<T> {
    void validaChat (T t) throws Exception;
}
