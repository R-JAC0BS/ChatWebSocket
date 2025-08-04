package br.com.socketchat.chat.Entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;


import java.util.ArrayList;
import java.util.List;

@Table(name = "chat")
@Entity
@Builder
public class ChatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCanal;

    private String admin;

    @ManyToMany(mappedBy = "chats")
    @JsonBackReference
    private List<UserEntity> users = new ArrayList<>();

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MessageEntity> mensagens = new ArrayList<>();


    @ElementCollection
    private List<String> usersConnectTochat;

    public ChatEntity(String nomeCanal, String admin) {
        this.nomeCanal = nomeCanal;
        this.admin = admin;
    }

    public List<String> getUsersConnectTochat() {
        return usersConnectTochat;
    }

    public void setUsersConnectTochat(List<String> usersConnectTochat) {
        this.usersConnectTochat = usersConnectTochat;
    }

    public ChatEntity() {
    }

    public List<MessageEntity> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<MessageEntity> mensagens) {
        this.mensagens = mensagens;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getNomeCanal() {
        return nomeCanal;
    }

    public void setNomeCanal(String nomeCanal) {
        this.nomeCanal = nomeCanal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void adicionarMensagem(MessageEntity mensagem) {
        this.mensagens.add(mensagem);
        mensagem.setChat(this);
    }
    public void adicionarUsuarioAoChat(String usuario){
        this.usersConnectTochat.add(usuario);
    }


}
