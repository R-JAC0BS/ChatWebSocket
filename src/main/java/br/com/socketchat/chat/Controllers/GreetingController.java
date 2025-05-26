package br.com.socketchat.chat.Controllers;


import br.com.socketchat.chat.Entity.Greeting;
import br.com.socketchat.chat.Entity.MessageEntity;
import br.com.socketchat.chat.Services.MessageService;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.util.HtmlUtils;

import java.util.Date;

@Controller
public class GreetingController {

    Date date = new Date();
    private final MessageService messageService;

    public GreetingController(MessageService messageService) {
        this.messageService = messageService;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    @CrossOrigin(origins = "https://chatwebsocketfrontend.onrender.com")
    public Greeting greeting(Greeting message) throws Exception {
        Thread.sleep(1000); // simulated delay
        messageService.SaveMessage(message);
        String data = String.valueOf(date);
        System.out.println(data);
        if (message.getContent().equals("/data")){
            return new Greeting(
                    HtmlUtils.htmlEscape(data),
                    HtmlUtils.htmlEscape(message.getUsername())
            );
        }

        return new Greeting(
                HtmlUtils.htmlEscape(message.getContent()),
                HtmlUtils.htmlEscape(message.getUsername())
        );
    }


}
