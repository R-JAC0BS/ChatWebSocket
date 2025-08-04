package br.com.socketchat.chat.Components.CustomErrors.CustomUserError;

import br.com.socketchat.chat.DTO.ErroValidacaoDTO;

public class ValidacaoException extends RuntimeException {
    private final ErroValidacaoDTO error;

    public ValidacaoException(ErroValidacaoDTO error) {
        super(error.mensagem());
        this.error = error;
    }

    public ErroValidacaoDTO getErro() {
        return error;
    }
}