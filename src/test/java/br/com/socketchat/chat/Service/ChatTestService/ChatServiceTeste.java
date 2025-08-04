package br.com.socketchat.chat.Service.ChatTestService;


import br.com.socketchat.chat.Entity.ChatEntity;
import br.com.socketchat.chat.Services.ChatService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ChatServiceTeste {

    @Autowired
    private ChatService chatService;

    @Test
    @Transactional
    public void deveRetornarListaDeChatsDoUsuario() {
        // Arrange
        String email = "NovoEmail@gmail.com";

        // Act
        List<ChatEntity> chats = chatService.listarChat(email);

        // Assert
        assertNotNull(chats, "A lista de chats não deve ser nula");
        assertFalse(chats.isEmpty(), "A lista de chats não deve estar vazia");

        // Opcional: imprimir os dados para conferência
        chats.forEach(chat -> {
            System.out.println("Chat ID: " + chat.getId());
            System.out.println("Nome: " + chat.getNomeCanal());
            System.out.println("Admin: " + chat.getAdmin());
            System.out.println("Mensagens: " + chat.getMensagens());
        });
    }


}
