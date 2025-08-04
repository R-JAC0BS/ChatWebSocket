package br.com.socketchat.chat.Controllers;


import br.com.socketchat.chat.Components.CustomErrors.CustomUserError.ValidacaoException;
import br.com.socketchat.chat.Components.Filter.UserComponent;
import br.com.socketchat.chat.DTO.ErroValidacaoDTO;
import br.com.socketchat.chat.DTO.UserDto;
import br.com.socketchat.chat.Entity.UserEntity;
import br.com.socketchat.chat.Repositorys.UserRepository;
import br.com.socketchat.chat.Services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public UserEntity getAllUsers(@RequestParam String email) throws Exception {
        UserEntity user = userRepository.findByEmail(email).get();
        return user;
    }

    @GetMapping("/findall")
    public List<UserEntity> getAllUsers() throws Exception {
        return userRepository.findAll();
    }


    @GetMapping("/teste-exception")
    public void testeException() throws ValidacaoException {
        throw new ValidacaoException(new ErroValidacaoDTO("Teste exceção"));
    }




































    @ExceptionHandler(ValidacaoException.class)
    @ResponseBody
    public ResponseEntity<Map<String, ErroValidacaoDTO>> handleValidacaoException(ValidacaoException ex) {
        System.out.println("ENTROU NO HANDLER DE ValidacaoException");
        Map<String, ErroValidacaoDTO> resposta = new HashMap<>();
        resposta.put("erro", ex.getErro());
        return ResponseEntity.badRequest().body(resposta);
    }
}
