package br.com.socketchat.chat.Repositorys;


import br.com.socketchat.chat.Entity.ChatEntity;

import java.util.List;

public interface ServiceImplementation {
     void criarChat(String nomeDoChat,String nomeDoUsuario ) throws Exception;
     void deletarChat(String admin,Long id) throws Exception;
     List<ChatEntity> listarChat (String admin) throws Exception;
}
