package br.com.socketchat.chat.Strategy.UserValidation;

import br.com.socketchat.chat.Components.CustomErrors.CustomUserError.ValidacaoException;

public interface CrendenciaisValidacao <T> {
    void validarCrendenciais(T t) throws ValidacaoException;
}
