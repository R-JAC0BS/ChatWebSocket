package br.com.socketchat.chat.Controllers;


import br.com.socketchat.chat.Entity.MessageEntity;
import br.com.socketchat.chat.Repositorys.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mg")
public class Messagers {

    @Autowired
    private final MessageRepository messageRepository;

    public Messagers(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @GetMapping()
    @CrossOrigin(origins = "*")
    public List<MessageEntity> findall () {
        return messageRepository.findAll();}
}
