package br.com.socketchat.chat.Controllers;



import br.com.socketchat.chat.Components.CustomErrors.CustomUserError.ValidacaoException;
import br.com.socketchat.chat.DTO.ErroValidacaoDTO;
import br.com.socketchat.chat.Services.ChatConnectedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/ChatConnected")
public class ConnectChatController {


    private final ChatConnectedService chatService;

    public ConnectChatController(ChatConnectedService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/join")
    public ResponseEntity<String> joinChat(@RequestParam Long idChat, @RequestParam String email) {
        chatService.jointToChat(idChat,email);
        return ResponseEntity.ok("Chat adicionado com sucesso!");
    }

    @DeleteMapping("/leave")
    public ResponseEntity<String> leaveChat(@RequestParam Long idChat, @RequestParam String email)  {
        chatService.exitChat(idChat,email);
        return ResponseEntity.ok("Chat removido com sucesso!");
    };



    @ExceptionHandler(ValidacaoException.class)
    @ResponseBody
    public ResponseEntity<Map<String, ErroValidacaoDTO>> handleValidacaoException(ValidacaoException ex) {
        System.out.println("ENTROU NO HANDLER DE ValidacaoException");
        Map<String, ErroValidacaoDTO> resposta = new HashMap<>();
        resposta.put("erro", ex.getErro());
        return ResponseEntity.badRequest().body(resposta);
    }
}
