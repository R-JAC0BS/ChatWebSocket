CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(50),
                       email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE chat (
                      id BIGSERIAL PRIMARY KEY,
                      nome_canal VARCHAR(255),
                      admin VARCHAR(255)
);

CREATE TABLE mensagem (
                          id BIGSERIAL PRIMARY KEY,
                          content VARCHAR(255),
                          sender VARCHAR(255),
                          timestamp TIMESTAMP,
                          chat_id BIGINT,
                          CONSTRAINT fk_mensagem_chat FOREIGN KEY (chat_id) REFERENCES chat(id) ON DELETE CASCADE
);

CREATE TABLE user_chat (
                           user_id BIGINT NOT NULL,
                           chat_id BIGINT NOT NULL,
                           PRIMARY KEY (user_id, chat_id),
                           CONSTRAINT fk_userchat_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                           CONSTRAINT fk_userchat_chat FOREIGN KEY (chat_id) REFERENCES chat(id) ON DELETE CASCADE
);

CREATE TABLE chat_users_connect_tochat (
                                           chat_id BIGINT NOT NULL,
                                           users_connect_tochat VARCHAR(255),
                                           CONSTRAINT fk_chat_users_connect_tochat_chat FOREIGN KEY (chat_id) REFERENCES chat(id) ON DELETE CASCADE
);
