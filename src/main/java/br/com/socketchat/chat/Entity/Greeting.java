package br.com.socketchat.chat.Entity;

import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

@Getter
@Setter
public class Greeting {
    @JsonProperty("content")
    private String content;

    @JsonProperty("username")
    private String username;

    public Greeting(String bot) {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Greeting() {
    }

    public String getContent() {
        return content;
    }

    public String setContent(String content) {
        this.content = content;
        return content;
    }

    public Greeting(String content, String username) {

        this.username = username;
        this.content = content;
    }
}