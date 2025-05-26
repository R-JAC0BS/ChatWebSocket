package br.com.socketchat.chat.Controllers;


import br.com.socketchat.chat.DTO.UserDto;
import br.com.socketchat.chat.Entity.UserEntity;
import br.com.socketchat.chat.Repositorys.UserRepository;
import br.com.socketchat.chat.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nickname")
public class UserController {


    @Autowired
    private UserService userService;

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping
    @CrossOrigin(origins = "https://chatwebsocketfrontend.onrender.com")
    public ResponseEntity<String> newnickname(@RequestBody UserDto newUser) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(newUser));
    }

    @GetMapping
    public List<UserEntity> getAllUsers() throws Exception {
        return userRepository.findAll();
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exception(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
