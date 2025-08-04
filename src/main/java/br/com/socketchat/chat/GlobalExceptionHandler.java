package br.com.socketchat.chat;

import br.com.socketchat.chat.Components.CustomErrors.CustomUserError.ValidacaoException;
import br.com.socketchat.chat.DTO.ErroValidacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
@ControllerAdvice
public class  GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    @ResponseBody
    public ResponseEntity<Map<String, ErroValidacaoDTO>> handleValidacaoException(ValidacaoException ex) {
        System.out.println("ENTROU NO HANDLER DE ValidacaoException");
        Map<String, ErroValidacaoDTO> resposta = new HashMap<>();
        resposta.put("erro", ex.getErro());
        return ResponseEntity.badRequest().body(resposta);
    }
}