package br.com.socketchat.chat.Controllers;


import br.com.socketchat.chat.Entity.ChatEntity;
import br.com.socketchat.chat.Services.ChatService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class chatController {

    private final ChatService chatService;

    public chatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping()
    public ResponseEntity<String> createChat(@RequestParam String chatName, @RequestParam String admin) throws Exception {
        chatService.criarChat(chatName,admin);
        return ResponseEntity.ok("Chat criado com sucesso!");
    }


    @GetMapping()
    public List<ChatEntity> getChat(@RequestParam String email)  {
        return chatService.listarChat(email);
    };

    @GetMapping("findChat")
    public ChatEntity getChat(@RequestParam Long chatId)  {
        return chatService.findChatByID(chatId);
    };

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteChat(@RequestParam Long id, @RequestParam String admin) throws Exception {
        chatService.deletarChat(admin,id);
        return ResponseEntity.ok("Chat deletado com sucesso!");
    }

    @DeleteMapping
    public ResponseEntity<String> removeUser(@RequestParam Long idChat, @RequestParam String userToRemove, @RequestParam String admin) throws Exception {
        chatService.removeUser(idChat,userToRemove,admin);
        return ResponseEntity.ok("Chat removido com sucesso!");
    }



}
