# 📡 ChatApp - WebSocket com Java Spring

[![Java](https://img.shields.io/badge/Java-21-007396?logo=java&logoColor=white)]()
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?logo=springboot&logoColor=white)]()
[![WebSocket](https://img.shields.io/badge/WebSocket-Real--Time-blue?logo=websocket&logoColor=white)]()
[![Flyway](https://img.shields.io/badge/Flyway-Database%20Migrations-CC0200?logo=flyway&logoColor=white)]()
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-336791?logo=postgresql&logoColor=white)]()
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)]()

---

## 🚀 Sobre o Projeto
O **ChatApp** é um sistema de chat em tempo real desenvolvido em **Java Spring Boot** com **WebSocket**, utilizando **Flyway** para versionamento do banco de dados e executado com **JDK 21**.

---

## 🛠️ Tecnologias Utilizadas
- ☕ **Java 21**
- 🌱 **Spring Boot**
- 🔌 **Spring WebSocket**
- 🐘 **PostgreSQL**
- 🛫 **Flyway**
- 🗄 **JPA/Hibernate**

---

## 📌 Funcionalidades
✅ Cadastro, atualização e busca de usuários  
✅ Criação, listagem e exclusão de chats  
✅ Conexão e desconexão de usuários em chats  
✅ Envio e recebimento de mensagens em tempo real  
✅ Versionamento de banco com Flyway

---

## 📡 Endpoints da API

### 👤 **User Controller**
| Método | Endpoint                | Descrição                             |
|--------|------------------------|---------------------------------------|
| GET    | `/user`                 | Busca informações de um usuário      |
| PUT    | `/user`                 | Atualiza informações de um usuário   |
| POST   | `/user`                 | Cria um novo usuário                 |
| GET    | `/user/teste-exception` | Testa tratamento de exceções         |
| GET    | `/user/findall`         | Lista todos os usuários              |

### 💬 **Chat Controller**
| Método | Endpoint           | Descrição                    |
|--------|-------------------|------------------------------|
| GET    | `/chat`            | Lista informações de chats   |
| POST   | `/chat`            | Cria um novo chat            |
| DELETE | `/chat`            | Remove um chat               |
| GET    | `/chat/findChat`   | Busca um chat específico     |
| DELETE | `/chat/delete`     | Deleta um chat específico    |

### 🔗 **Connect Chat Controller**
| Método | Endpoint               | Descrição                  |
|--------|-----------------------|----------------------------|
| POST   | `/ChatConnected/join` | Conecta usuário a um chat  |
| DELETE | `/ChatConnected/leave`| Remove usuário de um chat  |

### ✉ **Mensagens**
| Método | Endpoint | Descrição                |
|--------|----------|--------------------------|
| GET    | `/mg`    | Lista todas as mensagens |

---


---

## 🚀 Como Rodar o Projeto

### **Pré-requisitos**
- ☕ **JDK 21**
- 📦 **Maven**
- 🐘 **PostgreSQL**
- 🛫 **Flyway** configurado

### **Passos**
```bash
# 1. Clonar repositório
git clone https://github.com/seuusuario/seu-chat.git

# 2. Entrar na pasta do projeto
cd seu-chat

# 3. Configurar banco de dados no application.yml

# 4. Rodar a aplicação
mvn spring-boot:run
```

---

## 🔌 Conexão WebSocket
Endpoint exemplo:
```
ws://localhost:8080/chat
```

Exemplo de uso no **JavaScript**:
```javascript
const socket = new WebSocket("ws://localhost:8080/chat");
socket.onmessage = (event) => console.log("Mensagem recebida:", event.data);
socket.onopen = () => socket.send("Olá do cliente!");
```

---

## 🗂 Migrations com Flyway
Scripts de banco ficam em:
```
src/main/resources/db/migration
```
Exemplo de nome de arquivo:
```
V1__criar_tabela_usuario.sql
V2__criar_tabela_chat.sql
```

---

## 📜 Licença
Este projeto está sob a licença **MIT** – sinta-se livre para usar e modificar.
