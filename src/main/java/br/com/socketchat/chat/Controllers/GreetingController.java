package br.com.socketchat.chat.Controllers;


import br.com.socketchat.chat.Entity.Greeting;
import br.com.socketchat.chat.Entity.MessageEntity;
import br.com.socketchat.chat.Services.MessageService;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;

@Controller
public class GreetingController {

    private final MessageService messageService;

    private SimpMessagingTemplate messagingTemplate;

    public GreetingController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/mensagem/{chatId}")
    @CrossOrigin(origins = "http://localhost:3000/*")
    public void greeting(@DestinationVariable String chatId, Greeting message, Long id) throws Exception {
        try {
            messageService.saveMessage(message,id);
            messagingTemplate.convertAndSend("/topic/" + chatId, message);
        }catch (Exception e){
            throw new Exception("Erro ao enviar mensagem" + e.getMessage());
        }
    }

}
